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


package com.michaelgatesdev.OldLeaf.memory;

import java.nio.charset.Charset;

public class ByteString extends ByteData
{
    // ============================================================================================================================================ \\

    private String  data;
    private boolean mirrorBytes;

    // ============================================================================================================================================ \\


    /**
     * A {@link String} whose data can be easily represented in bytes
     *
     * @param data The {@link String}
     */
    public ByteString(String data)
    {
        this.data = data;
    }


    /**
     * A {@link String} whose data can be easily represented in bytes
     *
     * @param data        The {@link String}
     * @param mirrorBytes Whether to mirror bytes between characters (adding an empty 'spacer' byte between bytes)
     */
    public ByteString(String data, boolean mirrorBytes)
    {
        this.data = data;
        this.mirrorBytes = mirrorBytes;
    }


    // ============================================================================================================================================ \\


    @Override
    public byte[] getDataAsByteArray()
    {
        byte[] bytes = data.getBytes(Charset.forName("UTF-8"));

        if (mirrorBytes)
        {
            byte[] newBytes = new byte[(bytes.length << 1)];

            for (int i = 0; i < newBytes.length; i++)
            {
                newBytes[i] = ((i + 1) & 1) == 1 ? bytes[(i / 2)] : (byte) 0x00;
            }

            bytes = newBytes;
        }

        return bytes;
    }


    /**
     * @return The {@link String} data
     */
    public String getData()
    {
        return data;
    }

    // ============================================================================================================================================ \\
}
