package com.michaelgatesdev.OldLeaf.gui;

import com.michaelgatesdev.OldLeaf.Main;
import javafx.application.Platform;
import javafx.scene.Node;
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
    
    
    public void unlockNavigation(Node n)
    {
        Platform.runLater(() ->
        {
            Scene scene = n.getScene();
            TabPane navBar = (TabPane) scene.lookup("#navbar");
            for (Tab tab : navBar.getTabs())
            {
                logger.debug(String.format("Enabling %s tab", tab.getText()));
                tab.setDisable(false);
            }
            logger.debug("Unlocked navigation.");
        });
    }
    
    
    public void lockNavigation(Node n)
    {
        Platform.runLater(() ->
        {
            Scene scene = n.getScene();
            TabPane navBar = (TabPane) scene.lookup("#navbar");
            for (Tab tab : navBar.getTabs())
            {
                logger.debug(String.format("Disabling %s tab", tab.getText()));
                tab.setDisable(true);
            }
            logger.debug("Locked navigation.");
        });
    }
    
    
    public void populate()
    {
    }
    
    // ============================================================================================================================================ \\
}
