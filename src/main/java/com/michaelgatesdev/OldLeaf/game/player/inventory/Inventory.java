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

public interface Inventory
{
    /**
     * Adds specified item to the inventory
     *
     * @param item Item to add
     */
    public void addItem(GameItem item) throws GameItemAddException;


    /**
     * Removes specified item from the inventory
     *
     * @param item Item to remove
     */
    public void removeItem(GameItem item) throws GameItemRemoveException;


    /**
     * @param slot The item slot to place it in
     * @param item The item to be set in said slot
     */
    public void setItem(int slot, GameItem item);


    /**
     * @return Returns an array of all GameItems
     */
    public GameItem[] getItems();


    /**
     * @return Returns the maximize inventory size
     */
    public int getMaxSize();


    /**
     * @return Returns inventory's name
     */
    public String getName();
}
