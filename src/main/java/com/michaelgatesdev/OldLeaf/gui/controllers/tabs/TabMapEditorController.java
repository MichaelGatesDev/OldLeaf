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
                
                logger.debug(stage.getWidth() + " " + stage.getHeight());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        });
        
    }
    
    // ============================================================================================================================================ \\
}
