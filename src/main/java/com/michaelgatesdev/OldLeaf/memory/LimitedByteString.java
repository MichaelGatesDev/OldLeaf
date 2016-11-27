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

public class LimitedByteString extends ByteString
{
    // ============================================================================================================================================ \\


    /**
     * A {@link ByteString} which is limited to a set amount of characters
     *
     * @param data  The {@link String} data
     * @param limit The character limit
     */
    public LimitedByteString(String data, int limit)
    {
        super(data.length() < limit ? data : data.substring(0, limit));
    }


    /**
     * A {@link ByteString} which is limited to a set amount of characters
     *
     * @param data        The {@link String} data
     * @param limit       The character limit
     * @param mirrorBytes Whether to mirror bytes between characters
     */
    public LimitedByteString(String data, int limit, boolean mirrorBytes)
    {
        super(data.length() < limit ? data : data.substring(0, limit), mirrorBytes);
    }


    // ============================================================================================================================================ \\
}
