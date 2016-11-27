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

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TabMapEditorController implements Initializable
{
    // ============================================================================================================================================ \\

    private static final Logger logger = Logger.getLogger(TabMapEditorController.class);

    @FXML
    Button editTownButton;

    @FXML
    Button loadTownButton;

    @FXML
    Button saveTownButton;


    @FXML
    Button editIslandButton;

    @FXML
    Button loadIslandButton;

    @FXML
    Button saveIslandButton;


    // ============================================================================================================================================ \\


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        editTownButton.setOnMouseClicked(event ->
        {
            try
            {
                FXMLLoader fxmlLoader = new FXMLLoader(TabMapEditorController.class.getClassLoader().getResource("fxml/components/mapEditor/MapEditorBase.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.DECORATED);
                stage.setTitle("Map Editor");
                stage.setScene(new Scene(root));
                stage.show();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        });
    }


    // ============================================================================================================================================ \\
}
