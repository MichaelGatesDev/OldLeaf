package com.michaelgatesdev.OldLeaf.gui.components.grid;

public abstract class PaintGrid extends Grid
{
    // ============================================================================================================================================ \\


    /**
     * @param columns  The number of columns
     * @param rows     The number of rows
     * @param cellSize The size each cell should be
     */
    public PaintGrid(int columns, int rows, double cellSize)
    {
        super(columns, rows, cellSize);
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

                PaintableCell cell = new PaintableCell(this, startX, startY, endX, endY);
                this.getCells()[x][y] = cell;
            }
        }
    }

    // ============================================================================================================================================ \\
}
