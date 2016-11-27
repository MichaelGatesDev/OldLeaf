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

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

public class Grid extends Canvas
{
    // ============================================================================================================================================ \\

    private static final Logger logger = Logger.getLogger(Grid.class);

    private static final int    MIN_COLUMNS   = 1;
    private static final int    MIN_ROWS      = 1;
    private static final double MIN_CELL_SIZE = 5.0;

    private int    columns;
    private int    rows;
    private double cellSize;
    private double width;
    private double height;

    private Cell[][] cells;

    // ============================================================================================================================================ \\


    /**
     * Constructor which will automatically calculate the size of the grid (width & height) according to the cell size and the number of cells
     *
     * @param columns  The number of columns
     * @param rows     The number of rows
     * @param cellSize The size each cell should be
     */
    public Grid(int columns, int rows, double cellSize)
    {
        if (columns < MIN_COLUMNS)
        {
            throw new IllegalArgumentException(String.format("There must be at least %d column(s) in the grid!", MIN_COLUMNS));
        }
        if (rows < MIN_ROWS)
        {
            throw new IllegalArgumentException(String.format("There must be at least %d row(s) in the grid!", MIN_ROWS));
        }
        if (cellSize < MIN_CELL_SIZE)
        {
            throw new IllegalArgumentException(String.format("Cells must be at least %f unit(s) in size!", MIN_CELL_SIZE));
        }

        this.columns = columns;
        this.rows = rows;
        this.cellSize = cellSize;

        this.width = columns * cellSize;
        this.setWidth(width);

        this.height = rows * cellSize;
        this.setHeight(height);

        this.populate();
    }


    // ============================================================================================================================================ \\


    /**
     * Populates the grid with cells
     */
    protected void populate()
    {
        GraphicsContext graphics = this.getGraphicsContext2D();

        double gridWidth = columns * cellSize;
        double gridHeight = rows * cellSize;

        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());

        graphics.setStroke(Color.BLACK);
        graphics.setLineWidth(0.5);

        // draw vertical lines
        for (int x = 0; x < gridWidth + 1; x += cellSize)
        {
            graphics.strokeLine(x, 0, x, gridHeight);
        }
        // draw horizontal lines
        for (int y = 0; y < gridHeight + 1; y += cellSize)
        {
            graphics.strokeLine(0, y, gridWidth, y);
        }

        // Create cells
        this.cells = new Cell[columns][rows];

        // columns
        for (int x = 0; x < columns; x++)
        {
            // rows
            for (int y = 0; y < rows; y++)
            {
                int startX = (int) (x * cellSize);
                int startY = (int) (y * cellSize);
                int endX = (int) (startX + cellSize);
                int endY = (int) (startY + cellSize);

                Cell cell = new Cell(this, startX, startY, endX, endY);
                cells[x][y] = cell;
            }
        }
    }


    // ============================================================================================================================================ \\


    /**
     * @return The number of columns in the grid
     */
    public int getColumns()
    {
        return columns;
    }


    /**
     * @return The number of rows in the grid
     */
    public int getRows()
    {
        return rows;
    }


    /**
     * @return The width / height of cells
     */
    public double getCellSize()
    {
        return cellSize;
    }


    /**
     * @return A 2D array of all cells in the grid
     */
    public Cell[][] getCells()
    {
        return cells;
    }

    // ============================================================================================================================================ \\
}
