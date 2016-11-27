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
