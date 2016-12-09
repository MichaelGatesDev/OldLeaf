package com.michaelgatesdev.OldLeaf.gui.components.grid;

import com.michaelgatesdev.OldLeaf.Main;
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
    private Label objectNameLabel;
    
    private GameItem selectedItem;
    
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
    
    
    //TODO implement colors
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
    public void onCellClick(MouseButton button, Cell cell, int gridX, int gridY)
    {
        PaintableCell pc = (PaintableCell) cell;
        
        // TODO: Implement special map editor clicks
        if (button == MouseButton.PRIMARY)
        {
            Main.getInstance().getSaveGame().getTownMap().getTiles()[gridX][gridY] = selectedItem;
            pc.paint(getItemColor(selectedItem));
        }
        else if (button == MouseButton.SECONDARY)
        {
            if (pc.isPainted())
            {
                Main.getInstance().getSaveGame().getTownMap().getTiles()[gridX][gridY] = GameItem.AIR;
                pc.clean();
            }
        }
        else if (button == MouseButton.MIDDLE)
        {
            if (!pc.isPainted())
            {
                return;
            }
            
            this.selectedItem = Main.getInstance().getSaveGame().getTownMap().getTiles()[gridX][gridY];
        }
    }
    
    
    @Override
    public void onCellHover(Cell cell, int gridX, int gridY)
    {
        if (!checkLabels())
        {
            return;
        }
        coordinatesLabel.setText(String.format("X: %d Y: %d", gridX + 1, gridY + 1));
        
        GameItem item = Main.getInstance().getSaveGame().getTownMap().getTiles()[gridX][gridY];
        if (item != null)
        {
            objectNameLabel.setText(item.getName());
        }
        else
        {
            objectNameLabel.setText("Air");
        }
    }
    
    
    /**
     * Checks to see if the coordinatesLabel is valid
     *
     * @return If coordinatesLabel is not null and is usable
     */
    private boolean checkLabels()
    {
        if (coordinatesLabel != null)
        {
            return true;
        }
        
        Node coordsNode = this.getScene().lookup("#coordinatesLabel");
        if (coordsNode instanceof Label)
        {
            coordinatesLabel = (Label) coordsNode;
        }
        
        Node nameNode = this.getScene().lookup("#objectNameLabel");
        if (nameNode instanceof Label)
        {
            objectNameLabel = (Label) nameNode;
        }
        
        return true;
    }
    
    // ============================================================================================================================================ \\
}
