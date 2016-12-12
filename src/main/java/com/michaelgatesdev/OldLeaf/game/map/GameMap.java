package com.michaelgatesdev.OldLeaf.game.map;

import com.michaelgatesdev.OldLeaf.game.Acre;
import com.michaelgatesdev.OldLeaf.game.GameItem;
import com.michaelgatesdev.OldLeaf.game.Structure;

public abstract class GameMap
{
    // ============================================================================================================================================ \\
    
    public static final int TOWN_ACRE_COLUMNS = 5;
    public static final int TOWN_ACRE_ROWS    = 4;
    
    public static final int ISLAND_ACRE_COLUMNS = 2;
    public static final int ISLAND_ACRE_ROWS    = 2;
    
    public static final int TILE_COLUMNS = 16;
    public static final int TILE_ROWS    = 16;
    public static final int TILES_TOTAL  = TILE_COLUMNS * TILE_ROWS;
    
    private Acre[][]      acres;
    private Structure[][] structures;
    private GameItem[][]  tiles;
    
    
    // ============================================================================================================================================ \\
    
    
    public GameMap(GameMapRegion region)
    {
        switch (region)
        {
            case TOWN:
                this.acres = new Acre[TOWN_ACRE_COLUMNS][TOWN_ACRE_ROWS];
                this.structures = new Structure[TOWN_ACRE_COLUMNS * TILE_COLUMNS][TOWN_ACRE_ROWS * TILE_ROWS];
                this.tiles = new GameItem[TOWN_ACRE_COLUMNS * TILE_COLUMNS][TOWN_ACRE_ROWS * TILE_ROWS];
                break;
            case ISLAND:
                this.acres = new Acre[ISLAND_ACRE_COLUMNS][ISLAND_ACRE_ROWS];
                this.structures = new Structure[ISLAND_ACRE_COLUMNS * TILE_COLUMNS][ISLAND_ACRE_ROWS * TILE_ROWS];
                this.tiles = new GameItem[ISLAND_ACRE_COLUMNS * TILE_COLUMNS][ISLAND_ACRE_ROWS * TILE_ROWS];
                break;
            case UNKNOWN:
                this.acres = new Acre[][]{};
                this.structures = new Structure[][]{};
                this.tiles = new GameItem[][]{};
                break;
        }
    }
    
    // ============================================================================================================================================ \\
    
    
    public Acre[][] getAcres()
    {
        return acres;
    }
    
    
    public GameItem[][] getTiles()
    {
        return tiles;
    }
    
    
    public Structure[][] getStructures()
    {
        return structures;
    }
    
    // ============================================================================================================================================ \\
}
