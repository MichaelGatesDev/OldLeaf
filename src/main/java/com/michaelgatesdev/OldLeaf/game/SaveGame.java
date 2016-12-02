/*
 * Copyright (C) Michael Gates (MichaelGatesDev@gmail.com) 2015
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 */


package com.michaelgatesdev.OldLeaf.game;

import com.michaelgatesdev.OldLeaf.exceptions.SaveSizeInvalidException;
import com.michaelgatesdev.OldLeaf.game.map.GameMap;
import com.michaelgatesdev.OldLeaf.game.player.Player;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

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


    private enum SaveType
    {
        STANDARD,
        LEGACY,
        RAM,
    }

    // ============================================================================================================================================ \\


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

        readData(saveType);
    }


    private void readData(SaveType type)
    {
        try
        {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            logger.info("Loading save...");

            boolean isRamDump = saveType == SaveType.RAM;
            boolean isLegacy = saveType == SaveType.LEGACY;

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
            raf.seek(startOffset + (isLegacy ? OffsetsLegacy.TOWN_NATIVEFRUIT : OffsetsPlus.TOWN_NATIVEFRUIT));
            this.nativeFruit = FruitType.fromByteValue(raf.readByte());

            // grass shape
            raf.seek(startOffset + (isLegacy ? OffsetsLegacy.TOWN_GRASSTYPE : OffsetsPlus.TOWN_GRASSTYPE));
            this.grassShape = GrassShape.fromByteValue(raf.readByte());

            // town tree size
            raf.seek(startOffset + (isLegacy ? OffsetsLegacy.TOWN_TREESIZE : OffsetsPlus.TOWN_TREESIZE));
            this.townTreeSize = TownTreeSize.fromByteValue(raf.readByte());

            // play time
            raf.seek(startOffset + (isLegacy ? OffsetsLegacy.TOWN_PLAYTIME : OffsetsPlus.TOWN_PLAYTIME));
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

            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // ============================================================================================================================================ \\


    // ============================================================================================================================================ \\
}
