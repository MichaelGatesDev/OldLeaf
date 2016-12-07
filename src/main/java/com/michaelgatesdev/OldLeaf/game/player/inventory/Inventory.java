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
