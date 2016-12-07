package com.michaelgatesdev.OldLeaf.game.player.inventory;

import com.michaelgatesdev.OldLeaf.game.player.Player;

public class PlayerPocketInventory extends PlayerInventory
{
    // ============================================================================================================================================ \\
    
    
    @Override
    public int getMaxSize()
    {
        return Player.POCKETS_SIZE;
    }
    
    
    @Override
    public String getName()
    {
        return "Pockets";
    }
    
    // ============================================================================================================================================ \\
}
