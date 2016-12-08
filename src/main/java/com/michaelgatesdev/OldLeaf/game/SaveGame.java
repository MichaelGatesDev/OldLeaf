package com.michaelgatesdev.OldLeaf.game;

import com.michaelgatesdev.OldLeaf.Main;
import com.michaelgatesdev.OldLeaf.exceptions.GameItemAddException;
import com.michaelgatesdev.OldLeaf.exceptions.SaveSizeInvalidException;
import com.michaelgatesdev.OldLeaf.game.map.GameMap;
import com.michaelgatesdev.OldLeaf.game.map.TownMap;
import com.michaelgatesdev.OldLeaf.game.offsets.OffsetStash;
import com.michaelgatesdev.OldLeaf.game.player.Gender;
import com.michaelgatesdev.OldLeaf.game.player.Player;
import com.michaelgatesdev.OldLeaf.game.player.TPCRegion;
import com.michaelgatesdev.OldLeaf.game.player.inventory.PlayerInventory;
import com.michaelgatesdev.OldLeaf.memory.ByteArrayImage;
import com.michaelgatesdev.OldLeaf.util.HexUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class SaveGame
{
    // ============================================================================================================================================ \\
    
    private static final Logger logger = Logger.getLogger(SaveGame.class);
    
    private static final long GARDEN_SIZE_OLD = 522752L;
    private static final long RAM_SIZE        = 522624L;
    private static final long GARDEN_SIZE     = 563968L;
    
    private static final int SECURE_VALUE_LENGTH = 0x8; // Secure NAND value
    
    private static final int MAX_PLAYERS = 4;
    
    private File     file;
    private SaveType saveType;
    
    private byte[]       secureValue;
    private FruitType    nativeFruit;
    private GrassShape   grassShape;
    private TownTreeSize townTreeSize;
    private int          secondsPlayed;
    private int          minutesPlayed;
    private int          hoursPlayed;
    private int          daysPlayed;
    //TODO | Town ID
    private Player[]     players;
    private GameMap      townMap;
    private GameMap      islandMap;
    
    // ============================================================================================================================================ \\
    
    
    public SaveGame(File file)
    {
        this.file = file;
    }
    
    
    public void load() throws SaveSizeInvalidException
    {
        long fileSize = file.length();
        if (fileSize == GARDEN_SIZE)
        {
            logger.debug("Loading regular save..");
            saveType = SaveType.STANDARD;
        }
        else if (fileSize == GARDEN_SIZE_OLD)
        {
            logger.debug("Loading ~legacy~ save..");
            saveType = SaveType.LEGACY;
        }
        else if (fileSize == RAM_SIZE)
        {
            logger.debug("Loading ~ram dump~..");
            saveType = SaveType.RAM;
        }
        else
        {
            throw new SaveSizeInvalidException(String.format("Save size is invalid. %s", fileSize));
        }
        
        this.readData(saveType);
    }
    
    // ============================================================================================================================================ \\
    
    
    private void readData(SaveType type)
    {
        try
        {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            logger.info("Loading save...");
            
            boolean isRamDump = type == SaveType.RAM;
            boolean isLegacy = type == SaveType.LEGACY;
            OffsetStash offsets = isLegacy ? new OffsetsLegacy() : new OffsetsPlus();
            
            if (!isRamDump)
            {
                this.secureValue = new byte[]{};
                for (int i = 0; i < SECURE_VALUE_LENGTH; i++)
                {
                    byte b = raf.readByte();
                    secureValue = ArrayUtils.add(secureValue, b);
                }
            }
            
            // start at the beginning
            int startOffset = isRamDump ? 0x0 : 0x8; // ram dump doesn't have a secure value
            
            // native fruit
            raf.seek(startOffset + offsets.TOWN_NATIVEFRUIT());
            this.nativeFruit = FruitType.fromByteValue(raf.readByte());
            
            // grass shape
            raf.seek(startOffset + offsets.TOWN_GRASSTYPE());
            this.grassShape = GrassShape.fromByteValue(raf.readByte());
            
            // town tree size
            raf.seek(startOffset + offsets.TOWN_TREESIZE());
            this.townTreeSize = TownTreeSize.fromByteValue(raf.readByte());
            
            // play time
            raf.seek(startOffset + offsets.TOWN_PLAYTIME());
            short playTime = Short.reverseBytes(raf.readShort());
            this.secondsPlayed = playTime % 60;
            this.minutesPlayed = (playTime / 60) % 60;
            this.hoursPlayed = (playTime / 60 * 60) % 25;
            this.daysPlayed = (playTime / 60 * 60 * 24) % 25000;
//            raf.seek(currentOffset + 0x5C7BA);
//            this.daysPlayed = Short.reverseBytes(raf.readShort());
            
            // Player data
            for (int i = 0; i < MAX_PLAYERS; i++)
            {
                Player player = new Player();
                int currentOffset = startOffset + (offsets.PLAYER_SIZE() * i);
                
                raf.seek(currentOffset + offsets.PLAYER_PLAYTIME());
                player.setTimePlayed(raf.readInt());
                
                // --- APPEARANCE ---
                raf.seek(currentOffset + offsets.PLAYER_HAIRSTYLE());
                player.getAppearance().setHairStyle(Player.getHairStyle(raf.readByte()));
                
                raf.seek(currentOffset + offsets.PLAYER_HAIRCOLOR());
                player.getAppearance().setHairColor(Player.getHairColor(raf.readByte()));
                
                raf.seek(currentOffset + offsets.PLAYER_FACE());
                player.getAppearance().setFaceStyle(Player.getFaceStyle(raf.readByte()));
                
                raf.seek(currentOffset + offsets.PLAYER_EYECOLOR());
                player.getAppearance().setEyeColor(Player.getEyeColor(raf.readByte()));
                
                raf.seek(currentOffset + offsets.PLAYER_TAN());
                player.getAppearance().setTan(raf.readByte());
                
                raf.seek(currentOffset + offsets.PLAYER_GENDER());
                player.setGender(raf.readByte() == 0x00 ? Gender.MALE : Gender.FEMALE);
                
                // --- ID ---
                raf.seek(currentOffset + offsets.PLAYER_ID1());
                player.setId1(raf.readByte());
                
                raf.seek(currentOffset + offsets.PLAYER_ID2());
                player.setId2(raf.readByte());
                
                // --- TPC ---
                raf.seek(currentOffset + offsets.PLAYER_TPCREGION());
                player.setTPCRegion(TPCRegion.fromByteValue(raf.readByte()));
                
                // --- DATES ---
                raf.seek(currentOffset + offsets.PLAYER_BIRTHDAYMONTH());
                int birthMonth = raf.readByte();
                raf.seek(currentOffset + offsets.PLAYER_BIRTHDAYDAY());
                int birthDay = raf.readByte();
                player.setBirthDate(new GameDate(birthMonth, birthDay));
                
                raf.seek(currentOffset + offsets.PLAYER_REGYEAR());
                int regYear = raf.readByte();
                raf.seek(currentOffset + offsets.PLAYER_REGMONTH());
                int regMonth = raf.readByte();
                raf.seek(currentOffset + offsets.PLAYER_REGDAY());
                int regDay = raf.readByte();
                player.setRegistrationDate(new GameDate(regYear, regMonth, regDay));
                
                //TODO HOUSE
                
                //TODO PATTERNS
                
                // --- INVENTORY ---
                int pocketInvOff = currentOffset + offsets.PLAYER_POCKETS();
                loadInventory(raf, pocketInvOff, Player.POCKETS_SIZE, player.getPocketInventory());
                
                int dresserInvOff = currentOffset + offsets.PLAYER_DRESSERS();
                loadInventory(raf, dresserInvOff, Player.DRESSER_SIZE, player.getDresserInventory());
                
                int islandBoxInvOff = currentOffset + offsets.PLAYER_ISLANDBOX();
                loadInventory(raf, islandBoxInvOff, Player.ISLAND_BOX_SIZE, player.getIslandBoxInventory());
                
                // --- BADGES ---
//                int badgesOff = currentOffset + (isLegacy ? OffsetsLegacy.PLAYER_BADGES : offsets.PLAYER_BADGES);
//                for (int j = 0; j < player.getBadges().length; j++)
//                {
//                    raf.seek(badgesOff + j);
//                    player.getBadges()[i] = raf.readByte();
//                }
                // --- BADGES ---
                
                int imgOff = currentOffset + offsets.PLAYER_TPCPIC();
                raf.seek(imgOff);
                // if they have an image
                if (raf.readInt() == 0xe1ffd8ff)
                {
                    String imageBytes = "";
                    for (int x = 0; x < 0x1400; x++)
                    {
                        imageBytes += HexUtil.toHexString(new byte[]{ raf.readByte() });
                    }
                    
                    BufferedImage image = ImageIO.read(new ByteArrayInputStream(HexUtil.toByteArray(imageBytes)));
                    if (image != null)
                    {
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "jpg", baos);
                        byte[] bytes = baos.toByteArray();
                        
                        ByteArrayImage img = new ByteArrayImage(bytes);
                        player.setImage(img);
                    }
                }
                else
                {
                    player.setImage(null); //TODO not found image
                }
            }
            
            // TOWN
            int townItemsOffset = offsets.MAP_ITEMS();
            this.townMap = new TownMap();
            int acreN = 0;
            int townN = 0;
            int acreShift = 0;
            for (int i = 0; i < GameMap.TOWN_ACRE_COLUMNS * GameMap.TOWN_ACRE_ROWS; i++)
            {
                int acreX = i % 5;
                int acreY = i / 5;
                
                if (acreN >= 5 && acreN % 5 == 0)
                {
                    acreShift += 2;
                }
                
                int acreOffset = offsets.MAP_ACRES() + (8 * 2) + (acreN * 2) + (acreShift * 2);
                raf.seek(acreOffset);
                byte acreID = (byte) raf.read();
                
                logger.debug("Acre " + acreX + "," + acreY + " = 0x" + Integer.toHexString(acreID));
                
                Acre acre = new Acre();
                acre.setValue(acreID);
                acre.setImageFile(Main.getInstance().getAcreImageFromValue(acreID));
                townMap.getAcres()[acreX][acreY] = acre;
                
                for (int j = 0; j < GameMap.TILES_TOTAL; j++)
                {
                    int realX = acreX * 16 + (j % 16);
                    int realY = acreY * 16 + (j / 16);
                    
                    raf.seek(townItemsOffset + (townN * 4));
                    short id = Short.reverseBytes(raf.readShort());
                    byte flag1 = raf.readByte();
                    byte flag2 = raf.readByte();
                    
                    GameItem item = new GameItem.Builder()
                            .withName(Main.getInstance().getItemNameFromValue(id))
                            .withFlag1(flag1)
                            .withFlag2(flag2)
                            .withShortValue(id)
                            .build();
                    
                    townMap.getTiles()[realX][realY] = item;
                    townN++;
                }
                acreN++;
            }
            
            // ISLAND
            
            
            logger.info("Finished loading the save");
        }
        catch (IOException e)
        {
            logger.error("There was an error loading the save");
            e.printStackTrace();
        }
    }
    
    
    private void loadInventory(RandomAccessFile raf, long offset, int size, PlayerInventory inv)
    {
        try
        {
            for (int j = 0; j < size; j++)
            {
                long tempOff = offset + (j * 4);
                raf.seek(tempOff);
                short id = Short.reverseBytes(raf.readShort());
                byte flag1 = raf.readByte();
                byte flag2 = raf.readByte();
                
                GameItem item = new GameItem.Builder()
                        .withName("")
                        .withFlag1(flag1)
                        .withFlag2(flag2)
                        .withShortValue(id)
                        .build();
                
                try
                {
                    inv.addItem(item);
                }
                catch (GameItemAddException e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
    public File getFile()
    {
        return file;
    }
    
    // ============================================================================================================================================ \\
    
    
    public SaveType getSaveType()
    {
        return saveType;
    }
    
    
    public byte[] getSecureValue()
    {
        return secureValue;
    }
    
    
    public FruitType getNativeFruit()
    {
        return nativeFruit;
    }
    
    
    public GrassShape getGrassShape()
    {
        return grassShape;
    }
    
    
    public TownTreeSize getTownTreeSize()
    {
        return townTreeSize;
    }
    
    
    public int getSecondsPlayed()
    {
        return secondsPlayed;
    }
    
    
    public int getMinutesPlayed()
    {
        return minutesPlayed;
    }
    
    
    public int getHoursPlayed()
    {
        return hoursPlayed;
    }
    
    
    public int getDaysPlayed()
    {
        return daysPlayed;
    }
    
    
    public Player[] getPlayers()
    {
        return players;
    }
    
    
    public GameMap getTownMap()
    {
        return townMap;
    }
    
    
    public GameMap getIslandMap()
    {
        return islandMap;
    }
    
    
    private enum SaveType
    {
        STANDARD,
        LEGACY,
        RAM,
    }
    
    
    // ============================================================================================================================================ \\
}
