package com.michaelgatesdev.OldLeaf.gui.components.grid;

import com.michaelgatesdev.OldLeaf.Main;
import com.michaelgatesdev.OldLeaf.game.GridDimension;
import com.michaelgatesdev.OldLeaf.game.Structure;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

public class GameBuildingsGrid extends PaintGrid
{
    // ============================================================================================================================================ \\
    
    private static final Logger logger = Logger.getLogger(GameBuildingsGrid.class);
    
    private Label coordinatesLabel;
    private Label objectNameLabel;
    private Label selectedItemIDLabel;
    private Label selectedItemNameLabel;
    
    private Structure selectedStructure;
    
    // ============================================================================================================================================ \\
    
    
    /**
     * Creates a new instance of an EditableGrid
     *
     * @param columns  The number of columns
     * @param rows     The number of rows
     * @param cellSize The size each cell should be
     */
    public GameBuildingsGrid(int columns, int rows, double cellSize, Color separatorColor, double separatorWidth)
    {
        super(columns, rows, cellSize, separatorColor, separatorWidth);
        
        Platform.runLater(() ->
        {
            this.setId("GameBuildingsGrid");
            this.coordinatesLabel = (Label) this.getScene().lookup("#coordinatesLabel");
            this.objectNameLabel = (Label) this.getScene().lookup("#objectNameLabel");
            this.selectedItemIDLabel = (Label) this.getScene().lookup("#selectedItemIDLabel");
            this.selectedItemNameLabel = (Label) this.getScene().lookup("#selectedItemNameLabel");
        });
    }
    
    // ============================================================================================================================================ \\
    
    
    public void fillWithStructures(Structure[][] structures, int maxCols, int maxRows)
    {
        Color centerColor = Color.color(Color.GRAY.getRed(), Color.GRAY.getGreen(), Color.GRAY.getBlue(), 0.90);
        Color mainColor = Color.color(Color.DARKGRAY.getRed(), Color.DARKGRAY.getGreen(), Color.DARKGRAY.getBlue(), 0.90);
        
        for (int x = 0; x < maxCols; x++)
        {
            for (int y = 0; y < maxRows; y++)
            {
                Structure structure = structures[x][y];
                
                if (structure == null || structure.isNothing())
                {
                    continue;
                }
                
                GridDimension size = structure.getSize();
                
                int startX = (x - (size.getWidth() / 2));
                int endX = (x + (size.getWidth() / 2));
                int startY = (y - (size.getHeight() / 2));
                int endY = (y + (size.getHeight() / 2));
                
                
                for (int x2 = startX; x2 <= endX; x2++)
                {
                    for (int y2 = startY; y2 <= endY; y2++)
                    {
                        PaintableCell pc = (PaintableCell) this.getCells()[x2][y2];
                        
                        pc.paint(x2 == x && y2 == y ? centerColor : mainColor);
                    }
                }
                
            }
        }
    }
    
    
    @Override
    public void onCellClick(MouseButton button, Cell cell, int gridX, int gridY)
    {
        PaintableCell pc = (PaintableCell) cell;
        
        switch (button)
        {
            case PRIMARY:
                break;
            case SECONDARY:
                break;
            case MIDDLE:
                break;
        }
    }
    
    
    @Override
    public void onCellHover(Cell cell, int gridX, int gridY)
    {
        if (coordinatesLabel == null || objectNameLabel == null)
        {
            return;
        }
        
        coordinatesLabel.setText(String.format("X: %d Y: %d", gridX + 1, gridY + 1));
        
        Structure structure = Main.getInstance().getSaveGame().getTownMap().getStructures()[gridX][gridY];
        if (structure != null)
        {
            objectNameLabel.setText(structure.getName());
        }
        else
        {
            objectNameLabel.setText("(Nothing)");
        }
    }
    
    
    // ============================================================================================================================================ \\
}
