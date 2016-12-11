package com.michaelgatesdev.OldLeaf.gui.controllers.mapEditor;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class MapEditorLayersController implements Initializable
{
    // ============================================================================================================================================ \\
    
    private static final Logger logger = Logger.getLogger(MapEditorLayersController.class);
    
    @FXML
    public Label coordinatesLabel;
    
    @FXML
    public Label objectNameLabel;
    
    
    // ============================================================================================================================================ \\
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
    }
    
    // ============================================================================================================================================ \\
}
