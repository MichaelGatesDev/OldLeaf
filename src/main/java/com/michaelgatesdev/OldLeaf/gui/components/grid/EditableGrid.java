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

public abstract class EditableGrid extends Grid implements GridEvents
{
    // ============================================================================================================================================ \\


    /**
     * Creates a new instance of an EditableGrid
     *
     * @param columns  The number of columns
     * @param rows     The number of rows
     * @param cellSize The size each cell should be
     */
    public EditableGrid(int columns, int rows, double cellSize)
    {
        super(columns, rows, cellSize);
    }

    // ============================================================================================================================================ \\


    /**
     * Populates the grid with cells who have events
     */
    @Override
    protected void populate()
    {
        super.populate();

        // Cell clicked
        this.setOnMouseClicked(event ->
        {
            int x = (int) event.getX();
            int y = (int) event.getY();

            int gridX = (int) (x / this.getCellSize());
            int gridY = (int) (y / this.getCellSize());

            // ignore out of bounds
            if (gridX < 0 || gridX > getColumns() || gridY < 0 || gridY > getRows())
            {
                return;
            }

            Cell cell = this.getCells()[gridX][gridY];
            if (cell != null)
            {
                this.onCellClick(event.getButton(), cell, gridX, gridY);
            }
        });

        // Cell hovered over
        this.setOnMouseMoved(event ->
        {
            int x = (int) event.getX();
            int y = (int) event.getY();

            if (x < 0 || y < 0)
            {
                return;
            }

            int gridX = (int) (x / this.getCellSize());
            int gridY = (int) (y / this.getCellSize());

            // ignore out of bounds
            if (gridX < 0 || gridX > getColumns() || gridY < 0 || gridY > getRows())
            {
                return;
            }

            Cell cell = this.getCells()[gridX][gridY];
            if (cell != null)
            {
                this.onCellHover(cell, gridX, gridY);
            }
        });
    }

    // ============================================================================================================================================ \\
}
