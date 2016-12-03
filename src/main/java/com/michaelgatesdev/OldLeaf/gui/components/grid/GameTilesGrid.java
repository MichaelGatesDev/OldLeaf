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

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class GameTilesGrid extends PaintGrid
{
    // ============================================================================================================================================ \\
    
    private Label coordinatesLabel;
    
    // ============================================================================================================================================ \\
    
    
    /**
     * Creates a new instance of an EditableGrid
     *
     * @param columns  The number of columns
     * @param rows     The number of rows
     * @param cellSize The size each cell should be
     */
    public GameTilesGrid(int columns, int rows, double cellSize, Color separatorColor, double separatorWidth)
    {
        super(columns, rows, cellSize, separatorColor, separatorWidth);
    }
    
    // ============================================================================================================================================ \\
    
    
    @Override
    public void onCellClick(MouseButton button, Cell cell, int gridPosX, int gridPosY)
    {
        PaintableCell pc = (PaintableCell) cell;
        
        if (button == MouseButton.PRIMARY)
        {
            if (!pc.isPainted())
            {
                pc.paint();
            }
        }
        else if (button == MouseButton.SECONDARY)
        {
            if (pc.isPainted())
            {
                pc.clean();
            }
        }
    }
    
    
    @Override
    public void onCellHover(Cell cell, int gridX, int gridY)
    {
        if (!checkCoordinatesLabel())
        {
            return;
        }
        coordinatesLabel.setText(String.format("X: %d Y: %d", gridX + 1, gridY + 1));
    }
    
    
    /**
     * Checks to see if the coordinatesLabel is valid
     *
     * @return If coordinatesLabel is not null and is usable
     */
    private boolean checkCoordinatesLabel()
    {
        if (coordinatesLabel != null)
        {
            return true;
        }
        
        Node node = this.getScene().lookup("#coordinatesLabel");
        if (!(node instanceof Label))
        {
            return false;
        }
        
        coordinatesLabel = (Label) node;
        return true;
    }
    
    // ============================================================================================================================================ \\
}
