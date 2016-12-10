package com.michaelgatesdev.OldLeaf.gui.components.grid;

import com.michaelgatesdev.OldLeaf.game.Acre;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

public class GameAcresGrid extends ImageGrid
{
    // ============================================================================================================================================ \\
    
    private static final Logger logger = Logger.getLogger(GameAcresGrid.class);
    
    // ============================================================================================================================================ \\
    
    
    /**
     * Creates a new instance of an EditableGrid
     *
     * @param columns  The number of columns
     * @param rows     The number of rows
     * @param cellSize The size each cell should be
     */
    public GameAcresGrid(int columns, int rows, double cellSize, Color separatorColor, double separatorWidth)
    {
        super(columns, rows, cellSize, separatorColor, separatorWidth);
    }
    
    // ============================================================================================================================================ \\
    
    
    public void fillImages(Acre[][] acres, int acreColumns, int acreRows)
    {
        for (int x = 0; x < acreColumns; x++)
        {
            for (int y = 0; y < acreRows; y++)
            {
                Acre acre = acres[x][y];
                if (acre.getImageFile() == null)
                {
                    logger.debug(String.format("Acre image for X:%d | Y: %d is null", x, y));
                    continue;
                }
                Image image = new Image(acre.getImageFile().toURI().toString());
                
                ImageCell cell = (ImageCell) this.getCells()[x][y];
                cell.fillWithImage(image);
            }
        }
        
        this.redrawLines();
    }
    
    // ============================================================================================================================================ \\
    
    
    @Override
    public void onCellClick(MouseButton button, Cell cell, int gridPosX, int gridPosY)
    {
    }
    
    
    @Override
    public void onCellHover(Cell cell, int gridX, int gridY)
    {
    }
    
    
    // ============================================================================================================================================ \\
}
