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


package com.michaelgatesdev.OldLeaf;

import com.michaelgatesdev.OldLeaf.game.SaveGame;
import com.michaelgatesdev.OldLeaf.locale.UTF8Control;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Main extends Application
{
    // ============================================================================================================================================ \\
    
    private static final Logger logger = Logger.getLogger(Main.class);
    
    private static final int MAIN_WINDOW_WIDTH  = 1000;
    private static final int MAIN_WINDOW_HEIGHT = 650;
    
    private static Main instance;
    
    private ResourceBundle locale;
    
    private File rootDir;
    private File backupsDir;
    private File templatesDir;
    private File inventoryTemplatesDir;
    private File townTemplatesDir;
    private File islandTemplatesDir;
    private File appearanceTemplatesDir;
    
    // JavaFX stuff for later
    private Scene mainScene;
    
    private SaveGame saveGame;
    
    // ============================================================================================================================================ \\
    
    
    /**
     * The main method when the program starts
     *
     * @param args Arguments provided if used by command line
     */
    public static void main(String[] args)
    {
        instance = new Main();
        instance.initialize();
        // this kills the singleton
        Runtime.getRuntime().addShutdownHook(new Thread(() -> instance = null));
    }
    
    
    /**
     * Initializes the program in a non-static way
     */
    private void initialize()
    {
        // Grab locale bundle
        locale = ResourceBundle.getBundle("Locale", /*Locale.JAPAN,*/ new UTF8Control());
        
        // Create/Initialize all the directories */
        rootDir = new File(System.getProperty("user.dir") + "/");
        backupsDir = createDirectory(rootDir, "_backups", true);
        templatesDir = createDirectory(rootDir, "_templates", true);
        inventoryTemplatesDir = createDirectory(templatesDir, "inventory", true);
        townTemplatesDir = createDirectory(templatesDir, "town", true);
        islandTemplatesDir = createDirectory(templatesDir, "island", true);
        appearanceTemplatesDir = createDirectory(templatesDir, "appearance", true);
        
        // Init GUI
        launch();
    }
    
    
    @Override
    public void start(Stage stage) throws Exception
    {
        URL res = Main.class.getClassLoader().getResource("fxml/Main.fxml");
        
        if (res == null)
        {
            logger.error("Main resource path does not exist");
            return;
        }
        
        Parent root = FXMLLoader.load(res);
        
        Scene scene = new Scene(root, MAIN_WINDOW_WIDTH, MAIN_WINDOW_HEIGHT);
        this.mainScene = scene;
        
        // Package window
        stage.getIcons().add(new Image("img/logo.png"));
        stage.setTitle("Old Leaf");
        stage.setScene(scene);
        stage.setMinWidth(MAIN_WINDOW_WIDTH);
        stage.setMinHeight(MAIN_WINDOW_HEIGHT);
        stage.show();
    }
    
    // ============================================================================================================================================ \\
    
    
    /**
     * Creates a {@link File} directory.
     *
     * @param destDir the directory which will parent the created directory
     * @param name    the name of the directory
     * @param log     log the result to console
     * @return created directory
     */
    private File createDirectory(File destDir, String name, boolean log)
    {
        if (destDir == null || !destDir.exists())
        {
            if (log)
            {
                logger.error(String.format(locale.getString("File.Directory.DestinationNonexistent"), destDir));
            }
            return null;
        }
        
        File folder = new File(destDir, "/" + name + "/");
        if (!folder.exists())
        {
            boolean result = folder.mkdir();
            
            if (log)
            {
                if (result)
                {
                    logger.info(String.format(locale.getString("File.Directory.Created"), name, destDir.toString()));
                }
                else
                {
                    logger.error(String.format(locale.getString("File.Directory.ErrorCreating"), name, destDir.toString()));
                }
            }
        }
        return folder;
    }
    
    
    // ============================================================================================================================================ \\
    
    
    public void setSaveGame(SaveGame saveGame)
    {
        this.saveGame = saveGame;
    }
    
    
    // ============================================================================================================================================ \\
    
    
    public static Main getInstance()
    {
        return instance;
    }
    
    
    public Scene getMainScene()
    {
        return mainScene;
    }
    
    // ============================================================================================================================================ \\
}
