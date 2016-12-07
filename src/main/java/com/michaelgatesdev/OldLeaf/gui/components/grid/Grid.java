package com.michaelgatesdev.OldLeaf.gui.components.grid;

import com.michaelgatesdev.OldLeaf.gui.components.grid.handlers.CellListener;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Grid extends Canvas implements GridEvents
{
    // ============================================================================================================================================ \\
    
    private static final int    MIN_COLUMNS   = 1;
    private static final int    MIN_ROWS      = 1;
    private static final double MIN_CELL_SIZE = 5.0;
    
    private static final Color  SEPARATOR_COLOR  = Color.BLACK;
    private static final double SEPARATOR_SIZE   = 0.25D;
    private static final double SEPARATOR_OFFSET = (SEPARATOR_SIZE / 2.0D);
    
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
        
        // ~~register events~~
        // Cell clicked
        this.setOnMouseClicked(new CellListener.CellClickListener(this));
        // Cell dragged into
        this.setOnMouseDragged(new CellListener.CellClickListener(this));
        // Cell hovered over
        this.setOnMouseMoved(new CellListener.CellHoverListener(this));
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
        // draw column/row lines
        this.redrawLines();
        
        // Create cells
        this.setCells(new Cell[this.getColumns()][this.getRows()]);
    }
    
    
    public void redrawLines()
    {
        GraphicsContext graphics = this.getGraphicsContext2D();
        graphics.setStroke(separatorColor);
        graphics.setLineWidth(separatorWidth);
        
        // draw vertical lines
        for (int x = 0; x < width + 1; x += this.getCellSize())
        {
            graphics.strokeLine(x + SEPARATOR_OFFSET, 0, x + SEPARATOR_OFFSET, height);
        }
        // draw horizontal lines
        for (int y = 0; y < height + 1; y += this.getCellSize())
        {
            graphics.strokeLine(0, y + SEPARATOR_OFFSET, width, y + SEPARATOR_OFFSET);
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
    
    
    // ============================================================================================================================================ \\
    
    
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
    
    
    public void setCells(Cell[][] cells)
    {
        this.cells = cells;
    }
    
    // ============================================================================================================================================ \\
}
