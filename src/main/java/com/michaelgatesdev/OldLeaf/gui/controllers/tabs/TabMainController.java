package com.michaelgatesdev.OldLeaf.gui.controllers.tabs;

import com.michaelgatesdev.OldLeaf.Main;
import com.michaelgatesdev.OldLeaf.exceptions.SaveSizeInvalidException;
import com.michaelgatesdev.OldLeaf.game.SaveGame;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import org.apache.log4j.Logger;
import org.controlsfx.control.StatusBar;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class TabMainController implements Initializable
{
    // ============================================================================================================================================ \\
    
    private static final Logger logger = Logger.getLogger(TabMainController.class);
    
    private static final String SOURCE_CODE_URL = "https://github.com/MichaelGatesDev/OldLeaf/";
    private static final String DONATE_URL      = "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=YP8QAA3Q4BTWC";
    
    
    // ============================================================================================================================================ \\
    
    @FXML
    Button loadButton;
    @FXML
    Button exportButton;
    
    private boolean choosingFile;
    
    // ============================================================================================================================================ \\
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        // Create the status bar
        Platform.runLater(this::createStatusBar);
        
        
        loadButton.setOnMouseClicked(event ->
        {
            // If already selecting a file
            if (choosingFile)
            {
                return;
            }
            
            choosingFile = true;
            
            File file = showFileChooser("Load Animal Crossing New Leaf save", "Load save file", "dat", "bin");
            if (file == null)
            {
                logger.info("Cancelled loading save.");
                choosingFile = false;
                return;
            }
            
            SaveGame saveGame = new SaveGame(file);
            try
            {
                saveGame.load();
                Main.getInstance().setSaveGame(saveGame);
                Main.getInstance().getGuiManager().unlockNavigation(loadButton);
            }
            catch (SaveSizeInvalidException e)
            {
                logger.error("Invalid save size!");
                Main.getInstance().setSaveGame(null);
            }
            finally
            {
                choosingFile = false;
            }
        });
    }
    
    
    private void unlockNavigation()
    {
        Scene scene = loadButton.getScene();
        
        TabPane navBar = (TabPane) scene.lookup("#navbar");
        for (Tab tab : navBar.getTabs())
        {
            logger.debug(String.format("Enabling %s tab", tab.getText()));
            tab.setDisable(false);
        }
        logger.debug("Unlocked navigation.");
    }
    
    
    /**
     * Creates the main Status Bar of the program
     */
    private void createStatusBar()
    {
        Scene scene = loadButton.getScene();
        
        BorderPane borderPane = (BorderPane) scene.lookup("#mainPane");
        
        StatusBar statusBar = new StatusBar();
        statusBar.setId("statusBar");
        statusBar.setText("~ Please load save ~");
        statusBar.setProgress(0.0);
        
        statusBar.getRightItems().add(new Separator(Orientation.VERTICAL));
        
        Hyperlink sourceLink = new Hyperlink("Source Code");
        sourceLink.setOnMouseClicked(event ->
        {
            try
            {
                Desktop.getDesktop().browse(new URI(SOURCE_CODE_URL));
            }
            catch (IOException | URISyntaxException e)
            {
                e.printStackTrace();
            }
        });
        statusBar.getRightItems().add(sourceLink);
        
        Hyperlink donateLink = new Hyperlink("Donate");
        donateLink.setOnMouseClicked(event ->
        {
            try
            {
                Desktop.getDesktop().browse(new URI(DONATE_URL));
            }
            catch (IOException | URISyntaxException e)
            {
                e.printStackTrace();
            }
        });
        statusBar.getRightItems().add(donateLink);
        
        borderPane.setBottom(statusBar);
    }
    
    
    private File showFileChooser(String title, String description, String... extensions)
    {
        FileChooser chooser = new FileChooser();
        chooser.setTitle(title);
        chooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter(description, extensions));
        
        return chooser.showOpenDialog(null);
    }
    
    
    // ============================================================================================================================================ \\
}
