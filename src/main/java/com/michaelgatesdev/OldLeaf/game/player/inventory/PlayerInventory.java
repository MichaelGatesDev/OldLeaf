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

import com.michaelgatesdev.OldLeaf.exceptions.GameItemAddException;
import com.michaelgatesdev.OldLeaf.exceptions.GameItemRemoveException;
import com.michaelgatesdev.OldLeaf.game.GameItem;

import java.util.ArrayList;
import java.util.List;

public abstract class PlayerInventory implements Inventory
{
    // ============================================================================================================================================ \\
    
    private List<GameItem> gameItems;
    
    // ============================================================================================================================================ \\
    
    
    /**
     * An inventory suited for players
     */
    public PlayerInventory()
    {
        this.gameItems = new ArrayList<>();

//        // fill with empty slots
//        for (int i = 0; i < this.getMaxSize(); i++)
//        {
//            try
//            {
//                this.addItem(GameItem.EMPTY);
//            }
//            catch (GameItemAddException e)
//            {
//                e.printStackTrace();
//            }
//        }
    }
    
    
    /**
     * An inventory suited for players
     *
     * @param gameItems An {@link ArrayList} of items in the inventory
     */
    public PlayerInventory(List<GameItem> gameItems)
    {
        this.gameItems = gameItems;
    }
    
    // ============================================================================================================================================ \\
    
    
    @Override
    public void addItem(GameItem item) throws GameItemAddException
    {
        if (this.gameItems.size() >= this.getMaxSize())
        {
            throw new GameItemAddException("The inventory is full!");
        }
        this.gameItems.add(item);
    }
    
    
    @Override
    public void removeItem(GameItem item) throws GameItemRemoveException
    {
        if (!this.gameItems.contains(item))
        {
            throw new GameItemRemoveException("The inventory does not contain that item!");
        }
        this.gameItems.remove(item);
    }
    
    
    @Override
    public void setItem(int slot, GameItem item)
    {
        this.gameItems.set(slot, item);
    }
    
    // ============================================================================================================================================ \\
    
    
    @Override
    public GameItem[] getItems()
    {
        return this.gameItems.toArray(new GameItem[gameItems.size()]);
    }
    
    
    @Override
    public abstract int getMaxSize();
    
    
    @Override
    public abstract String getName();
    
    // ============================================================================================================================================ \\
}
