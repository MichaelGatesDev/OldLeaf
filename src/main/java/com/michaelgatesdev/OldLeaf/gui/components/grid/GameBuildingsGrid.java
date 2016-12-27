package com.michaelgatesdev.OldLeaf.gui.components.grid;

import com.michaelgatesdev.OldLeaf.Main;
import com.michaelgatesdev.OldLeaf.game.GridDimension;
import com.michaelgatesdev.OldLeaf.game.GridLayout;
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
    
    
    //TODO fix structure sizes and origins
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
                GridLayout layout = structure.getLayout();
                
                /*
                    111 | 11111 | 111 | 21 | 121
                    111 | 11111 | 121 |    |
                    121 | 11211 | 111 |    |
                    
                    7      12      4     0    1
                   3x3    5x3     3x3   2x1  3x1
                 */
                
                int originIndex = layout.getOriginIndex(); // 7, 12, 4
                int originColumn = layout.getOriginColumn(size);
                int originRow = layout.getOriginRow(size);
                
                int startX = x - ((size.getWidth() - originColumn) / 2);
                int startY = y - ((size.getHeight() - originRow) / 2);
                
                int n = 0;
                for (int i = 0; i < size.getHeight(); i++)
                {
                    for (int j = 0; j < size.getWidth(); j++)
                    {
                        char c = layout.getChars()[n];
                        PaintableCell pc = (PaintableCell) this.getCells()[startX + j][startY + i];
                        
                        switch (c)
                        {
                            case '0':
                                pc.paint(Color.TRANSPARENT);
                                break;
                            case '1':
                                pc.paint(mainColor);
                                break;
                            case '2':
                                pc.paint(centerColor);
                                break;
                        }
                        
                        n++;
                    }
                }

//                int startX = (originX - (size.getWidth() / 2));
//                int endX = (originX + (size.getWidth() / 2));
//                int startY = (originY - (size.getHeight() / 2));
//                int endY = (originY + (size.getHeight() / 2));
//
//
//                for (int x2 = startX; x2 <= endX; x2++)
//                {
//                    for (int y2 = startY; y2 <= endY; y2++)
//                    {
//                        PaintableCell pc = (PaintableCell) this.getCells()[x2][y2];
//
//                        pc.paint(x2 == originX && y2 == originY ? centerColor : mainColor);
//                    }
//                }
                
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
