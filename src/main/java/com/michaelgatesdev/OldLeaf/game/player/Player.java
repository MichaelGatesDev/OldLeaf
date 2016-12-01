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


package com.michaelgatesdev.OldLeaf.game.player;

import com.michaelgatesdev.OldLeaf.game.GameDate;
import com.michaelgatesdev.OldLeaf.game.player.appearance.*;
import com.michaelgatesdev.OldLeaf.game.player.inventory.PlayerDresserInventory;
import com.michaelgatesdev.OldLeaf.game.player.inventory.PlayerInventory;
import com.michaelgatesdev.OldLeaf.game.player.inventory.PlayerIslandBoxInventory;
import com.michaelgatesdev.OldLeaf.game.player.inventory.PlayerPocketInventory;
import com.michaelgatesdev.OldLeaf.memory.ByteArrayImage;
import com.michaelgatesdev.OldLeaf.memory.LimitedByteString;
import javafx.scene.image.Image;

public class Player
{
    // ============================================================================================================================================ \\

    public static final EyeColor[] EYE_COLORS = new EyeColor[]{
            new EyeColor((short) 0x00, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/eye_color/b_0x00.png"))),
            new EyeColor((short) 0x01, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/eye_color/b_0x01.png"))),
            new EyeColor((short) 0x02, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/eye_color/b_0x02.png"))),
            new EyeColor((short) 0x03, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/eye_color/b_0x03.png"))),
            new EyeColor((short) 0x04, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/eye_color/b_0x04.png"))),
            new EyeColor((short) 0x05, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/eye_color/b_0x05.png"))),
            };

    public static final FaceStyle[] FACE_STYLES = new FaceStyle[]{
            new FaceStyle((short) 0x0A, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/f_0x0A.png"))),
            new FaceStyle((short) 0x0B, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/f_0x0B.png"))),
            new FaceStyle((short) 0x0C, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/f_0x0C.png"))),
            new FaceStyle((short) 0x01, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/f_0x01.png"))),
            new FaceStyle((short) 0x02, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/f_0x02.png"))),
            new FaceStyle((short) 0x03, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/f_0x03.png"))),
            new FaceStyle((short) 0x04, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/f_0x04.png"))),
            new FaceStyle((short) 0x05, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/f_0x05.png"))),
            new FaceStyle((short) 0x06, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/f_0x06.png"))),
            new FaceStyle((short) 0x07, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/f_0x07.png"))),
            new FaceStyle((short) 0x08, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/f_0x08.png"))),
            new FaceStyle((short) 0x09, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/f_0x09.png"))),
            new FaceStyle((short) 0x0A, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/m_0x0A.png"))),
            new FaceStyle((short) 0x0B, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/m_0x0B.png"))),
            new FaceStyle((short) 0x0C, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/m_0x0C.png"))),
            new FaceStyle((short) 0x01, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/m_0x01.png"))),
            new FaceStyle((short) 0x02, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/m_0x02.png"))),
            new FaceStyle((short) 0x03, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/m_0x03.png"))),
            new FaceStyle((short) 0x04, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/m_0x04.png"))),
            new FaceStyle((short) 0x05, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/m_0x05.png"))),
            new FaceStyle((short) 0x06, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/m_0x06.png"))),
            new FaceStyle((short) 0x07, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/m_0x07.png"))),
            new FaceStyle((short) 0x08, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/m_0x08.png"))),
            new FaceStyle((short) 0x09, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/face_style/m_0x09.png"))),
            };

    public static final HairColor[] HAIR_COLORS = new HairColor[]{
            new HairColor((short) 0x0A, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_color/b_0x0A.png"))),
            new HairColor((short) 0x0B, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_color/b_0x0B.png"))),
            new HairColor((short) 0x0C, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_color/b_0x0C.png"))),
            new HairColor((short) 0x0D, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_color/b_0x0D.png"))),
            new HairColor((short) 0x0E, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_color/b_0x0E.png"))),
            new HairColor((short) 0x0F, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_color/b_0x0F.png"))),
            new HairColor((short) 0x00, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_color/b_0x00.png"))),
            new HairColor((short) 0x01, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_color/b_0x01.png"))),
            new HairColor((short) 0x02, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_color/b_0x02.png"))),
            new HairColor((short) 0x03, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_color/b_0x03.png"))),
            new HairColor((short) 0x04, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_color/b_0x04.png"))),
            new HairColor((short) 0x05, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_color/b_0x05.png"))),
            new HairColor((short) 0x06, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_color/b_0x06.png"))),
            new HairColor((short) 0x07, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_color/b_0x07.png"))),
            new HairColor((short) 0x08, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_color/b_0x08.png"))),
            new HairColor((short) 0x09, Gender.BOTH, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_color/b_0x09.png"))),
            };

    public static final HairStyle[] HAIR_STYLES = new HairStyle[]{
            new HairStyle((short) 0x1A, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/f_0x1A.png"))),
            new HairStyle((short) 0x1B, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/f_0x1B.png"))),
            new HairStyle((short) 0x1C, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/f_0x1C.png"))),
            new HairStyle((short) 0x1D, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/f_0x1D.png"))),
            new HairStyle((short) 0x1E, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/f_0x1E.png"))),
            new HairStyle((short) 0x1F, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/f_0x1F.png"))),
            new HairStyle((short) 0x10, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/f_0x10.png"))),
            new HairStyle((short) 0x11, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/f_0x11.png"))),
            new HairStyle((short) 0x12, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/f_0x12.png"))),
            new HairStyle((short) 0x13, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/f_0x13.png"))),
            new HairStyle((short) 0x14, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/f_0x14.png"))),
            new HairStyle((short) 0x15, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/f_0x15.png"))),
            new HairStyle((short) 0x16, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/f_0x16.png"))),
            new HairStyle((short) 0x17, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/f_0x17.png"))),
            new HairStyle((short) 0x18, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/f_0x18.png"))),
            new HairStyle((short) 0x19, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/f_0x19.png"))),
            new HairStyle((short) 0x20, Gender.FEMALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/f_0x20.png"))),
            new HairStyle((short) 0x0A, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/m_0x0A.png"))),
            new HairStyle((short) 0x0B, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/m_0x0B.png"))),
            new HairStyle((short) 0x0C, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/m_0x0C.png"))),
            new HairStyle((short) 0x0D, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/m_0x0D.png"))),
            new HairStyle((short) 0x0E, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/m_0x0E.png"))),
            new HairStyle((short) 0x0F, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/m_0x0F.png"))),
            new HairStyle((short) 0x00, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/m_0x00.png"))),
            new HairStyle((short) 0x01, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/m_0x01.png"))),
            new HairStyle((short) 0x02, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/m_0x02.png"))),
            new HairStyle((short) 0x03, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/m_0x03.png"))),
            new HairStyle((short) 0x04, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/m_0x04.png"))),
            new HairStyle((short) 0x05, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/m_0x05.png"))),
            new HairStyle((short) 0x06, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/m_0x06.png"))),
            new HairStyle((short) 0x07, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/m_0x07.png"))),
            new HairStyle((short) 0x08, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/m_0x08.png"))),
            new HairStyle((short) 0x09, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/m_0x09.png"))),
            new HairStyle((short) 0x10, Gender.MALE, new Image(Player.class.getClassLoader().getResourceAsStream("img/hair_style/m_0x10.png"))),
            };

    // ============================================================================================================================================ \\

    private static final int MAX_NAME_LENGTH      = 10;
    private static final int MAX_TOWN_NAME_LENGTH = 10;

    private LimitedByteString name;
    private Gender            gender;
    private LimitedByteString townName;
    private ByteArrayImage    image;
    private TPCRegion         tpcRegion;
    private GameDate          birthDate;
    private GameDate          registrationDate;
    //    private PlayerAppearance  appearance;
    private PlayerInventory   pocketInventory;
    private PlayerInventory   dresserInventory;
    private PlayerInventory   islandBoxInventory;
    //    private PlayerBadge[]     badges;
    //    private PlayerEmotion[]   emotions;
    private int               pocketBells;
    private int               bankBells;

    // ============================================================================================================================================ \\


    public Player()
    {
        this.name = new LimitedByteString("Player", MAX_NAME_LENGTH, true);
        this.gender = Gender.UNKNOWN;
        this.townName = new LimitedByteString("Town Name", MAX_TOWN_NAME_LENGTH, true);
        this.image = new ByteArrayImage(new byte[]{});
        this.tpcRegion = TPCRegion.UNKNOWN;
        this.birthDate = new GameDate(1, 1, 1900);
        this.registrationDate = new GameDate(1, 1, 1900);
//        this.appearance = new PlayerAppearance();
        this.pocketInventory = new PlayerPocketInventory();
        this.dresserInventory = new PlayerDresserInventory();
        this.islandBoxInventory = new PlayerIslandBoxInventory();
//        this.badges = new PlayerBadge[]{};
//        this.emotions = new PlayerEmotion[]{};
    }

    // ============================================================================================================================================ \\


    /**
     * @return The player's name
     */
    public LimitedByteString getName()
    {
        return name;
    }


    /**
     * @return The player's gender
     */
    public Gender getGender()
    {
        return gender;
    }


    /**
     * @return The name of the town the player lives in
     */
    public LimitedByteString getTownName()
    {
        return townName;
    }


    /**
     * @return The TPC image of the player
     */
    public ByteArrayImage getImage()
    {
        return image;
    }


    /**
     * @return The region the player is from
     */
    public TPCRegion getTPCRegion()
    {
        return tpcRegion;
    }


    /**
     * @return The birthdate of the player
     */
    public GameDate getBirthDate()
    {
        return birthDate;
    }


    /**
     * @return The registration date of the player (When they started playing)
     */
    public GameDate getRegistrationDate()
    {
        return registrationDate;
    }


    /**
     * @return The player's pockets
     */
    public PlayerInventory getPocketInventory()
    {
        return pocketInventory;
    }


    /**
     * @return The player's dresser/cabinets/lockers
     */
    public PlayerInventory getDresserInventory()
    {
        return dresserInventory;
    }


    /**
     * @return The player's island box (at the dock/island)
     */
    public PlayerInventory getIslandBoxInventory()
    {
        return islandBoxInventory;
    }


    /**
     * @return The amount of bells the player is holding
     */
    public int getBankBells()
    {
        return bankBells;
    }


    /**
     * @return The amount of bells the player has in the bank (ADB)
     */
    public int getPocketBells()
    {
        return pocketBells;
    }


    // ============================================================================================================================================ \\
}
