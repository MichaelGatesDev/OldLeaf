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


import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

public class ArrayTest
{
    private static final int[] NUMBERS = new int[] { 0, 5, 13, -1, 0xAD, 0xB2A4 };


    @Test
    public void testContains()
    {
        Assert.assertTrue(ArrayUtils.contains(NUMBERS, 5));
        Assert.assertTrue(ArrayUtils.contains(NUMBERS, 13));
        Assert.assertFalse(ArrayUtils.contains(NUMBERS, 0xAA));
        Assert.assertFalse(ArrayUtils.contains(NUMBERS, 0xAD));
    }


}
