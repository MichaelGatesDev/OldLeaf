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

import javafx.scene.input.MouseButton;

public interface GridEvents
{
    /**
     * Event fired when a cell on a grid is clicked on
     *
     * @param button   The mouse button pressed
     * @param cell     The cell clicked
     * @param gridPosX The X position in the grid (NOT PIXEL)
     * @param gridPosY The Y position in the grid (NOT PIXEL)
     */
    void onCellClick(MouseButton button, Cell cell, int gridPosX, int gridPosY);


    /**
     * Event fired when mouse is hovering over a cell
     *
     * @param cell  The cell being hovered over
     * @param gridX The grid X position of the mouse
     * @param gridY The grid Y position of the mouse
     */
    void onCellHover(Cell cell, int gridX, int gridY);
}
