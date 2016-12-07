package com.michaelgatesdev.OldLeaf.gui.components.grid;

import com.michaelgatesdev.OldLeaf.gui.controllers.mapEditor.MapEditorController;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

public class GameAcresGrid extends ImageGrid
{
    // ============================================================================================================================================ \\
    
    private static final Logger logger = Logger.getLogger(GameAcresGrid.class);
    
    private MapEditorController mapEditorController;
    
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
        
        this.mockAcres();
    }
    
    // ============================================================================================================================================ \\
    
    
    private void mockAcres()
    {
//        // Fill grid with random acres
//        List<Acre> acres = new ArrayList<>(Main.getInstance().getAcres().values());
//        Cell[][] cells = getCells();
//        for (Cell[] cellArr : cells)
//        {
//            for (Cell cell : cellArr)
//            {
//                Image image = acres.get(new Random().nextInt(acres.size() - 1)).getImage();
//                cell.fillWithImage(image);
//            }
//        }
    }
    
    // ============================================================================================================================================ \\
    
    
    @Override
    public void onCellClick(MouseButton button, Cell cell, int gridPosX, int gridPosY)
    {
        // This event can't be fired because there is a thieving grid above it
        // TODO allow grid to be clicked under another grid
    }
    
    
    @Override
    public void onCellHover(Cell cell, int gridX, int gridY)
    {
    }
    
    // ============================================================================================================================================ \\
}
