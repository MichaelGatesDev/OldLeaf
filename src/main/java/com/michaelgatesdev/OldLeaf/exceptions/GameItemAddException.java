package com.michaelgatesdev.OldLeaf.exceptions;

import com.michaelgatesdev.OldLeaf.game.GameItem;
import com.michaelgatesdev.OldLeaf.game.player.inventory.PlayerInventory;

public class GameItemAddException extends Exception
{
    /**
     * Thrown when there was an issue adding a {@link GameItem} to a {@link PlayerInventory} likely because the inventory was full
     */
    public GameItemAddException()
    {
    }
    
    
    /**
     * Thrown when there was an issue adding a {@link GameItem} to a {@link PlayerInventory} likely because the inventory was full
     */
    public GameItemAddException(String message)
    {
        super(message);
    }
    
    
    /**
     * Thrown when there was an issue adding a {@link GameItem} to a {@link PlayerInventory} likely because the inventory was full
     */
    
    public GameItemAddException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    
    /**
     * Thrown when there was an issue adding a {@link GameItem} to a {@link PlayerInventory} likely because the inventory was full
     */
    public GameItemAddException(Throwable cause)
    {
        super(cause);
    }
    
    
    /**
     * Thrown when there was an issue adding a {@link GameItem} to a {@link PlayerInventory} likely because the inventory was full
     */
    public GameItemAddException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
