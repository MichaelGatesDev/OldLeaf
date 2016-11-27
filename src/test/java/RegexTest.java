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

import com.michaelgatesdev.OldLeaf.util.RegexUtil;
import org.junit.Assert;
import org.junit.Test;

public class RegexTest
{
    @Test
    public void testHex()
    {
        Assert.assertTrue(RegexUtil.HEX_PATTERN.matcher("0xFF").find());            // 0xFF = 255
        Assert.assertTrue(RegexUtil.HEX_PATTERN.matcher("0xAABBCC").find());        // Test of basic characters
        Assert.assertTrue(RegexUtil.HEX_PATTERN.matcher("0xABCDEF").find());        // In-order characters
        Assert.assertTrue(RegexUtil.HEX_PATTERN.matcher("0x101010").find());        // Looks like binary, but it's obviously not
        Assert.assertTrue(RegexUtil.HEX_PATTERN.matcher("0x0000000").find());       // Has 7 digits
        Assert.assertTrue(RegexUtil.HEX_PATTERN.matcher("0x000000D").find());       // Has 7 digits
        Assert.assertTrue(RegexUtil.HEX_PATTERN.matcher("Has 0xFF").find());  // Has 7 digits

        Assert.assertFalse(RegexUtil.HEX_PATTERN.matcher("0xFG").find());           // G is not a valid value
        Assert.assertFalse(RegexUtil.HEX_PATTERN.matcher("Random 0x").find());         // random string
    }
}
