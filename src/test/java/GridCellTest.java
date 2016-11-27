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

import com.michaelgatesdev.OldLeaf.gui.components.grid.Cell;
import org.junit.Assert;
import org.junit.Test;

public class GridCellTest
{
    @Test
    public void testCellSizes()
    {
        Cell cellA = new Cell(null, 0, 0, 5, 5);
        Assert.assertEquals(cellA.getSize(), 25, 0.0);

        Cell cellB = new Cell(null, 15, 15, 25, 25);
        Assert.assertEquals(cellB.getSize(), 100, 0.0);
    }
}
