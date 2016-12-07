package com.michaelgatesdev.OldLeaf.exceptions;

import com.michaelgatesdev.OldLeaf.game.GameItem;
import com.michaelgatesdev.OldLeaf.game.player.inventory.PlayerInventory;

public class GameItemRemoveException extends Exception
{
    /**
     * Thrown when there was an issue removing a {@link GameItem} from a {@link PlayerInventory} likley because the inventory did not contain the item
     */
    public GameItemRemoveException()
    {
    }
    
    
    /**
     * Thrown when there was an issue removing a {@link GameItem} from a {@link PlayerInventory} likley because the inventory did not contain the item
     */
    public GameItemRemoveException(String message)
    {
        super(message);
    }
    
    
    /**
     * Thrown when there was an issue removing a {@link GameItem} from a {@link PlayerInventory} likley because the inventory did not contain the item
     */
    
    public GameItemRemoveException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    
    /**
     * Thrown when there was an issue removing a {@link GameItem} from a {@link PlayerInventory} likley because the inventory did not contain the item
     */
    public GameItemRemoveException(Throwable cause)
    {
        super(cause);
    }
    
    
    /**
     * Thrown when there was an issue removing a {@link GameItem} from a {@link PlayerInventory} likley because the inventory did not contain the item
     */
    public GameItemRemoveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
