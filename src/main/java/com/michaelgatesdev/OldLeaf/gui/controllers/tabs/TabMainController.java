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


package com.michaelgatesdev.OldLeaf.gui.controllers.tabs;

import com.michaelgatesdev.OldLeaf.Main;
import com.michaelgatesdev.OldLeaf.exceptions.SaveSizeInvalidException;
import com.michaelgatesdev.OldLeaf.game.SaveGame;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import org.apache.log4j.Logger;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class TabMainController implements Initializable
{
    // ============================================================================================================================================ \\

    private static final Logger logger = Logger.getLogger(TabMainController.class);

    // ============================================================================================================================================ \\

    @FXML
    Button loadSaveButton;
    @FXML
    Button saveSaveButton;
    @FXML
    Button loadRamButton;
    @FXML
    Button saveRamButton;

    private boolean choosingFile;

    // ============================================================================================================================================ \\


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        loadSaveButton.setOnMouseClicked(event ->
        {
            if (choosingFile)
            {
                return;
            }

            choosingFile = true;

            File file = showFileChooser("Load Animal Crossing New Leaf save", "Load garden.dat", "dat");
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


    private File showFileChooser(String title, String description, String... extensions)
    {
        FileChooser chooser = new FileChooser();
        chooser.setTitle(title);
        chooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter(description, extensions));

        return chooser.showOpenDialog(null);
    }


    // ============================================================================================================================================ \\
}
