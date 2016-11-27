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
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.controlsfx.control.StatusBar;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main extends Application
{
    // ============================================================================================================================================ \\

    private static final Logger logger = Logger.getLogger(Main.class);

    private static final int MAIN_WINDOW_WIDTH  = 1000;
    private static final int MAIN_WINDOW_HEIGHT = 650;

    private static final String SOURCE_CODE_URL = "https://github.com/MichaelGatesDev/OldLeaf/";
    private static final String DONATE_URL      = "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=YP8QAA3Q4BTWC";

    private static Main instance;

    private File rootDir;
    private File backupsDir;
    private File templatesDir;
    private File inventoryTemplatesDir;
    private File townTemplatesDir;
    private File islandTemplatesDir;
    private File appearanceTemplatesDir;

    // JavaFX stuff for later
    private Scene scene;

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
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            instance = null;
        }));
    }


    /**
     * Initializes the program in a non-static way
     */
    private void initialize()
    {
        // Create/Initialize all the directories */
        rootDir = new File(System.getProperty("user.dir") + "/");
        backupsDir = createDirectory(rootDir, "_backups", true);
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
        Parent root = FXMLLoader.load(Main.class.getClassLoader().getResource("fxml/Main.fxml"));

        scene = new Scene(root, MAIN_WINDOW_WIDTH, MAIN_WINDOW_HEIGHT);

        createStatusBar();

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
     * Creates the main Status Bar of the program
     */
    private void createStatusBar()
    {
        BorderPane borderPane = (BorderPane) scene.lookup("#mainPane");

        StatusBar statusBar = new StatusBar();
        statusBar.setId("statusBar");
        statusBar.setText("Please load a game save");
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

    // ============================================================================================================================================ \\


    /**
     * Creates a {@link File} directory.
     *
     * @param destDir the directory which will parent the created directory
     * @param name    the name of the directory
     * @param log     log the result to console
     *
     * @return created directory
     */
    private File createDirectory(File destDir, String name, boolean log)
    {
        if (destDir == null || !destDir.exists())
        {
            logger.error(String.format("Destination directory doesn't exist."));
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
                    logger.info(String.format("Created directory '(%s)' in '(%s)'", name, destDir.toString()));
                }
                else
                {
                    logger.error(String.format("Error creating directory '(%s)' in '(%s)'", name, destDir.toString()));
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


    /**
     * @return The singleton instance of the program for easy access
     */
    public static Main getInstance()
    {
        return instance;
    }


    /**
     * @return The main scene of the program
     */
    public Scene getMainScene()
    {
        return scene;
    }


    public SaveGame getSaveGame()
    {
        return saveGame;
    }


    // ============================================================================================================================================ \\
}
