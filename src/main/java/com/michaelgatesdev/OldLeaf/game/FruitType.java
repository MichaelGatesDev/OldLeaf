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

public enum FruitType
{
    // ============================================================================================================================================ \\

    APPLES((byte) 0x01),
    ORANGES((byte) 0x02),
    PEARS((byte) 0x03),
    PEACHES((byte) 0x04),
    CHERRIES((byte) 0x05);

    // ============================================================================================================================================ \\

    private byte value;

    // ============================================================================================================================================ \\


    FruitType(byte value)
    {
        this.value = value;
    }

    // ============================================================================================================================================ \\


    /**
     * Parses a {@link FruitType} from a byte
     *
     * @param value The byte to parse from
     *
     * @return Parsed {@link FruitType} or null if none
     */
    public static FruitType fromByteValue(byte value)
    {
        for (FruitType ft : FruitType.values())
        {
            if (ft.value == value)
            {
                return ft;
            }
        }
        return null;
    }


    /**
     * Parses a {@link FruitType} from a {@link String}
     *
     * @param s The string to parse from
     *
     * @return Parsed {@link FruitType} or null if none
     */
    public static FruitType fromString(String s)
    {
        for (FruitType gs : FruitType.values())
        {
            if (s.equalsIgnoreCase(gs.toString().replace("_", "")))
            {
                return gs;
            }
        }
        return null;
    }


    public byte getValue()
    {
        return value;
    }

    // ============================================================================================================================================ \\
}
