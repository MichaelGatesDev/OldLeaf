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


package com.michaelgatesdev.OldLeaf.game.map;

import com.michaelgatesdev.OldLeaf.game.Acre;
import com.michaelgatesdev.OldLeaf.game.GameItem;

public class GameMap
{
    // ============================================================================================================================================ \\

    private static final int TOWN_ACRES_OOB = 5;
    private static final int TOWN_ACRES     = 20;
    private static final int ISLAND_ACRES   = 4;
    private static final int TILES_PER_ACRE = 256;

    private GameMapRegion region;
    private Acre[]        acres;
    private GameItem[]    tiles;

    // ============================================================================================================================================ \\


    public GameMap(GameMapRegion region)
    {
        this.region = region;
        this.acres = new Acre[region == GameMapRegion.TOWN ? TOWN_ACRES : ISLAND_ACRES];
        this.tiles = new GameItem[TILES_PER_ACRE * acres.length];
    }


    // ============================================================================================================================================ \\


    public void setTiles(GameItem[] tiles)
    {
        this.tiles = tiles;
    }


    public void setAcres(Acre[] acres)
    {
        this.acres = acres;
    }


    // ============================================================================================================================================ \\


    public GameItem[] getTiles()
    {
        return tiles;
    }


    public Acre[] getAcres()
    {
        return acres;
    }


    public GameMapRegion getRegion()
    {
        return region;
    }


    // ============================================================================================================================================ \\
}
