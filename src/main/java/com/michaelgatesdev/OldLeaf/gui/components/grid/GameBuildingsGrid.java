package com.michaelgatesdev.OldLeaf.gui.components.grid;

import com.michaelgatesdev.OldLeaf.Main;
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
    
    
    public void fillWithStructures(Structure[][] tiles, int maxCols, int maxRows)
    {
        
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
            objectNameLabel.setText("Air");
        }
    }
    
    
    // ============================================================================================================================================ \\
}
