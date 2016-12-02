package com.michaelgatesdev.OldLeaf.gui.components.grid;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Grid extends Canvas implements GridEvents
{
    // ============================================================================================================================================ \\

    private static final int    MIN_COLUMNS   = 1;
    private static final int    MIN_ROWS      = 1;
    private static final double MIN_CELL_SIZE = 5.0;

    private static final Color  SEPARATOR_COLOR = Color.BLACK;
    private static final double SEPARATOR_SIZE  = 0.5D;

    private Color  separatorColor;
    private double separatorWidth;

    private int    columns;
    private int    rows;
    private double cellSize;
    private double width;
    private double height;

    private Cell[][] cells;

    // ============================================================================================================================================ \\


    /***
     * @param columns  The number of columns
     * @param rows     The number of rows
     * @param cellSize The size each cell should be
     */
    public Grid(int columns, int rows, double cellSize, Color separatorColor, double separatorWidth)
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

        this.separatorColor = separatorColor;
        this.separatorWidth = separatorWidth;

        this.populate();
    }


    /***
     * @param columns  The number of columns
     * @param rows     The number of rows
     * @param cellSize The size each cell should be
     */
    public Grid(int columns, int rows, double cellSize)
    {
        this(columns, rows, cellSize, SEPARATOR_COLOR, SEPARATOR_SIZE);
    }


    // ============================================================================================================================================ \\


    /**
     * Populates the grid with cells
     */
    public void populate()
    {
        GraphicsContext graphics = this.getGraphicsContext2D();

        double gridWidth = this.getColumns() * this.getCellSize();
        double gridHeight = this.getRows() * this.getCellSize();

        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());

        graphics.setStroke(separatorColor);
        graphics.setLineWidth(separatorWidth);

        // draw vertical lines
        for (int x = 0; x < gridWidth + 1; x += this.getCellSize())
        {
            graphics.strokeLine(x, 0, x, gridHeight);
        }
        // draw horizontal lines
        for (int y = 0; y < gridHeight + 1; y += this.getCellSize())
        {
            graphics.strokeLine(0, y, gridWidth, y);
        }

        // Create cells
        this.setCells(new Cell[this.getColumns()][this.getRows()]);


        // --- \\

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


    public void setCells(Cell[][] cells)
    {
        this.cells = cells;
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
