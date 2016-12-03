package com.michaelgatesdev.OldLeaf.gui.components.grid;

import javafx.scene.paint.Color;

public abstract class ImageGrid extends Grid
{
    // ============================================================================================================================================ \\
    
    
    /**
     * @param columns  The number of columns
     * @param rows     The number of rows
     * @param cellSize The size each cell should be
     */
    public ImageGrid(int columns, int rows, double cellSize, Color separatorColor, double separatorWidth)
    {
        super(columns, rows, cellSize, separatorColor, separatorWidth);
    }
    // ============================================================================================================================================ \\
    
    
    @Override
    public void populate()
    {
        super.populate();
        
        for (int x = 0; x < this.getColumns(); x++)
        {
            for (int y = 0; y < this.getRows(); y++)
            {
                int startX = (int) (x * this.getCellSize());
                int startY = (int) (y * this.getCellSize());
                int endX = (int) (startX + this.getCellSize());
                int endY = (int) (startY + this.getCellSize());
                
                ImageCell cell = new ImageCell(this, startX, startY, endX, endY);
                this.getCells()[x][y] = cell;
            }
        }
    }
    
    // ============================================================================================================================================ \\
}
