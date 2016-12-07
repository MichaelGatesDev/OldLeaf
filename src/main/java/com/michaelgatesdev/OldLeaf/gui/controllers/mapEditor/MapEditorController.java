/*
 * Copyright (C) Michael Gates (MichaelGatesDev@gmail.com) 2015
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 */


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
        
        int maxCols = GameMap.TOWN_ACRE_COLUMNS * GameMap.TILE_COLUMNS;
        int maxRows = GameMap.TOWN_ACRE_ROWS * GameMap.TILE_ROWS;
        tilesGrid = new GameTilesGrid(maxCols, maxRows, TILE_SIZE, Color.BLACK, 0.25D);
        gridContainer.getChildren().add(tilesGrid);
        logger.debug("Filling tiles grid...");
        tilesGrid.fillWithItems(Main.getInstance().getSaveGame().getTownMap().getTiles(), maxCols, maxRows);
        logger.debug("Finished filling tiles grid.");
        
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
