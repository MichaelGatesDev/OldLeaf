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

public enum TownTreeSize
{
    // ============================================================================================================================================ \\

    SMALLER((byte) 0x01),
    SMALL((byte) 0x02),
    MEDIUM((byte) 0x03),
    BIG((byte) 0x04),
    BIGGER((byte) 0x05),
    MORE_BIGGER((byte) 0x06),
    FULL_GROWN((byte) 0x07);

    // ============================================================================================================================================ \\

    private byte value;

    // ============================================================================================================================================ \\


    TownTreeSize(byte value)
    {
        this.value = value;
    }


    /**
     * Parses a {@link TownTreeSize} from a byte
     *
     * @param value The byte to parse from
     *
     * @return Parsed {@link TownTreeSize}
     */
    public static TownTreeSize fromByteValue(byte value)
    {
        for (TownTreeSize ts : TownTreeSize.values())
        {
            if (ts.value == value)
            {
                return ts;
            }
        }
        return null;
    }


    /**
     * Parses a {@link TownTreeSize} from a {@link String}
     *
     * @param s The string to parse from
     *
     * @return Parsed {@link TownTreeSize} or null if none
     */
    public static TownTreeSize fromString(String s)
    {
        for (TownTreeSize gs : TownTreeSize.values())
        {
            if (s.equalsIgnoreCase(gs.toString().replace("_", "")))
            {
                return gs;
            }
        }
        return null;
    }

    // ============================================================================================================================================ \\
}
