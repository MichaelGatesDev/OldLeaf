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

import com.michaelgatesdev.OldLeaf.memory.LimitedByteString;
import org.junit.Assert;
import org.junit.Test;

public class StringTest
{
    @Test
    public void testLimitedStrings()
    {
        int maxUsernameLength = 16;
        LimitedByteString username = new LimitedByteString("This username can only be 16 characters long.", maxUsernameLength);

        Assert.assertTrue(username.getData().length() == maxUsernameLength);
    }
}
