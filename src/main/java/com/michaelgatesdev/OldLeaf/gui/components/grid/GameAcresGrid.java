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


package com.michaelgatesdev.OldLeaf.gui.components.grid;

import com.michaelgatesdev.OldLeaf.gui.controllers.mapEditor.MapEditorController;
import javafx.scene.input.MouseButton;
import org.apache.log4j.Logger;

public class GameAcresGrid extends ImageGrid
{
    // ============================================================================================================================================ \\

    private static final Logger logger = Logger.getLogger(GameAcresGrid.class);

    private MapEditorController mapEditorController;

    // ============================================================================================================================================ \\


    /**
     * Creates a new instance of an EditableGrid
     *
     * @param columns  The number of columns
     * @param rows     The number of rows
     * @param cellSize The size each cell should be
     */
    public GameAcresGrid(int columns, int rows, double cellSize)
    {
        super(columns, rows, cellSize);

        mockAcres();
    }

    // ============================================================================================================================================ \\


    private void mockAcres()
    {
//        // Fill grid with random acres
//        List<Acre> acres = new ArrayList<>(Main.getInstance().getAcres().values());
//        Cell[][] cells = getCells();
//        for (Cell[] cellArr : cells)
//        {
//            for (Cell cell : cellArr)
//            {
//                Image image = acres.get(new Random().nextInt(acres.size() - 1)).getImage();
//                cell.fillWithImage(image);
//            }
//        }
    }

    // ============================================================================================================================================ \\


    @Override
    public void onCellClick(MouseButton button, Cell cell, int gridPosX, int gridPosY)
    {
        // This event can't be fired because there is a thieving grid above it
        // TODO allow grid to be clicked under another grid
    }


    @Override
    public void onCellHover(Cell cell, int gridX, int gridY)
    {
    }

    // ============================================================================================================================================ \\
}
