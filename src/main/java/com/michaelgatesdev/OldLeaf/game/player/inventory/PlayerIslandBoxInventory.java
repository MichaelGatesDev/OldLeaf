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


package com.michaelgatesdev.OldLeaf.game.player.inventory;

public class PlayerIslandBoxInventory extends PlayerInventory
{
    // ============================================================================================================================================ \\

    public static final int ISLAND_BOX_SIZE = 40;

    // ============================================================================================================================================ \\


    @Override
    public int getMaxSize()
    {
        return ISLAND_BOX_SIZE;
    }


    @Override
    public String getName()
    {
        return "Island Box";
    }

    // ============================================================================================================================================ \\
}
