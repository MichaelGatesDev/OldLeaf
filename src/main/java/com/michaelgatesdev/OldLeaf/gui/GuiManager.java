package com.michaelgatesdev.OldLeaf.gui;

import com.michaelgatesdev.OldLeaf.Main;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import org.apache.log4j.Logger;

public class GuiManager
{
    // ============================================================================================================================================ \\
    
    private static final Logger logger = Logger.getLogger(GuiManager.class);
    
    private Main main;
    
    // ============================================================================================================================================ \\
    
    
    public GuiManager(Main main)
    {
        this.main = main;
    }
    
    // ============================================================================================================================================ \\
    
    
    public void unlockNavigation()
    {
        Platform.runLater(() ->
        {
            Scene scene = main.getMainScene();
            
            TabPane navBar = (TabPane) scene.lookup("#navbar");
            for (Tab tab : navBar.getTabs())
            {
                logger.debug(String.format("Enabling %s tab", tab.getText()));
                tab.setDisable(false);
            }
            logger.debug("Unlocked navigation.");
        });
    }
    
    
    public void lockNavigation()
    {
        
    }
    
    
    public void populate()
    {
    }
    
    // ============================================================================================================================================ \\
}
