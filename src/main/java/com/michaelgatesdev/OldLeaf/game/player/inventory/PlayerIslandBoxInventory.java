package com.michaelgatesdev.OldLeaf.game.player.inventory;

import com.michaelgatesdev.OldLeaf.game.player.Player;

public class PlayerIslandBoxInventory extends PlayerInventory
{
    // ============================================================================================================================================ \\
    
    
    @Override
    public int getMaxSize()
    {
        return Player.ISLAND_BOX_SIZE;
    }
    
    
    @Override
    public String getName()
    {
        return "Island Box";
    }
    
    // ============================================================================================================================================ \\
}
