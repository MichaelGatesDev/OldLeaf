package com.michaelgatesdev.OldLeaf.game.player.inventory;

import com.michaelgatesdev.OldLeaf.game.player.Player;

public class PlayerDresserInventory extends PlayerInventory
{
    // ============================================================================================================================================ \\
    
    
    @Override
    public int getMaxSize()
    {
        return Player.DRESSER_SIZE;
    }
    
    
    @Override
    public String getName()
    {
        return "Dresser";
    }
    
    // ============================================================================================================================================ \\
}
