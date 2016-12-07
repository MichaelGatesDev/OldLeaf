package com.michaelgatesdev.OldLeaf.gui.components.grid;

import com.michaelgatesdev.OldLeaf.game.GameItem;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

public class GameTilesGrid extends PaintGrid
{
    // ============================================================================================================================================ \\
    
    private static final Logger logger = Logger.getLogger(GameTilesGrid.class);
    
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
    
    
    public void fillWithItems(GameItem[][] tiles, int maxCols, int maxRows)
    {
        for (int x = 0; x < maxCols; x++)
        {
            for (int y = 0; y < maxRows; y++)
            {
                Color c = this.getItemColor(tiles[x][y]);
                
                PaintableCell pc = (PaintableCell) this.getCells()[x][y];
                pc.paint(c);
            }
        }
    }
    
    
    private Color getItemColor(GameItem item)
    {
        if (item.isNothing())
        {
            return Color.TRANSPARENT;
        }
        else
        {
            return Color.RED;
        }
    }
    
    
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
