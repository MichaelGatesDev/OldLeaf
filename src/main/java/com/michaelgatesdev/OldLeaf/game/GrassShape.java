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

public enum GrassShape
{
    // ============================================================================================================================================ \\

    TRIANGLE_SQUARE((byte) 0x00),
    CIRCLE_STAR((byte) 0x01),
    SQUARE_CIRCLE((byte) 0x02);

    // ============================================================================================================================================ \\

    private byte value;

    // ============================================================================================================================================ \\


    GrassShape(byte value)
    {
        this.value = value;
    }


    // ============================================================================================================================================ \\


    /**
     * Parses a {@link GrassShape} from a byte
     *
     * @param value The byte to parse from
     *
     * @return Parsed {@link GrassShape} or null if none
     */
    public static GrassShape fromByteValue(byte value)
    {
        for (GrassShape gs : GrassShape.values())
        {
            if (gs.value == value)
            {
                return gs;
            }
        }
        return null;
    }


    /**
     * Parses a {@link GrassShape} from a {@link String}
     *
     * @param s The string to parse from
     *
     * @return Parsed {@link GrassShape} or null if none
     */
    public static GrassShape fromString(String s)
    {
        for (GrassShape gs : GrassShape.values())
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
