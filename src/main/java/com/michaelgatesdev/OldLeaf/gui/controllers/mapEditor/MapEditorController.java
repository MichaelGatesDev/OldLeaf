package com.michaelgatesdev.OldLeaf.gui.controllers.mapEditor;

import com.michaelgatesdev.OldLeaf.Main;
import com.michaelgatesdev.OldLeaf.game.map.GameMap;
import com.michaelgatesdev.OldLeaf.gui.components.grid.GameAcresGrid;
import com.michaelgatesdev.OldLeaf.gui.components.grid.GameTilesGrid;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class MapEditorController implements Initializable
{
    // ============================================================================================================================================ \\
    
    private static final Logger logger = Logger.getLogger(MapEditorController.class);
    
    private static final double TILE_SIZE = 10.0;
    
    @FXML
    StackPane gridContainer;
    
    private GameAcresGrid acresGrid;
    private GameTilesGrid tilesGrid;
    
    // ============================================================================================================================================ \\
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        this.createGrid();
    }
    
    
    private void createGrid()
    {
        long startTime = System.currentTimeMillis();
        
        acresGrid = new GameAcresGrid(GameMap.TOWN_ACRE_COLUMNS, GameMap.TOWN_ACRE_ROWS, TILE_SIZE * 16, Color.BLACK, 1.0D);
        gridContainer.getChildren().add(acresGrid);
        acresGrid.fillImages(Main.getInstance().getSaveGame().getTownMap().getAcres(), GameMap.TOWN_ACRE_COLUMNS, GameMap.TOWN_ACRE_ROWS);
        
        int maxCols = GameMap.TOWN_ACRE_COLUMNS * GameMap.TILE_COLUMNS;
        int maxRows = GameMap.TOWN_ACRE_ROWS * GameMap.TILE_ROWS;
        tilesGrid = new GameTilesGrid(maxCols, maxRows, TILE_SIZE, Color.BLACK, 0.25D);
        gridContainer.getChildren().add(tilesGrid);
        tilesGrid.fillWithItems(Main.getInstance().getSaveGame().getTownMap().getTiles(), maxCols, maxRows);
        
        //TODO buildings grid
        
        long finishTime = System.currentTimeMillis();
        
        logger.debug(String.format("Total draw time for grid(s) %d ms", finishTime - startTime));
    }
    
    // ============================================================================================================================================ \\
    
    
    public GameTilesGrid getTilesGrid()
    {
        return tilesGrid;
    }
    
    
    public GameAcresGrid getAcresGrid()
    {
        return acresGrid;
    }
    
    
    // ============================================================================================================================================ \\
}
