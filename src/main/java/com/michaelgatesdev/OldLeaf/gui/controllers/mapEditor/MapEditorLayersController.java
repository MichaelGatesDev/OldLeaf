package com.michaelgatesdev.OldLeaf.gui.controllers.mapEditor;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
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
    
    @FXML
    public CheckBox itemsLayerCheckBox;
    @FXML
    public CheckBox buildingsLayerCheckBox;
    @FXML
    public CheckBox acresLayerCheckBox;
    
    private Node tilesGrid;
    private Node buildingsGrid;
    private Node acresGrid;
    
    // ============================================================================================================================================ \\
    
    
    public MapEditorLayersController()
    {
        Platform.runLater(() ->
        {
            tilesGrid = acresLayerCheckBox.getScene().lookup("GameTilesGrid");
            buildingsGrid = acresLayerCheckBox.getScene().lookup("GameBuildingsGrid");
            acresGrid = acresLayerCheckBox.getScene().lookup("GameAcresGrid");
        });
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        itemsLayerCheckBox.selectedProperty().addListener((observable, oldValue, newValue) ->
        {
            // box is checked
            if (newValue)
            {
                tilesGrid.setVisible(true);
                buildingsGrid.setVisible(true);
                acresGrid.setVisible(true);
                
                buildingsLayerCheckBox.setSelected(true);
                buildingsLayerCheckBox.setDisable(true);
                buildingsGrid.setVisible(true);
                acresLayerCheckBox.setSelected(true);
                acresLayerCheckBox.setDisable(true);
                acresGrid.setVisible(true);
            }
            // box is unchecked
            else
            {
                tilesGrid.setVisible(false);
                buildingsGrid.setVisible(true);
                acresGrid.setVisible(true);
                
                buildingsLayerCheckBox.setSelected(true);
                buildingsLayerCheckBox.setDisable(false);
                buildingsGrid.setVisible(true);
                acresLayerCheckBox.setSelected(true);
                acresLayerCheckBox.setDisable(true);
                acresGrid.setVisible(true);
            }
        });
        buildingsLayerCheckBox.selectedProperty().addListener((observable, oldValue, newValue) ->
        {
            // box is checked
            if (newValue)
            {
                tilesGrid.setVisible(false);
                buildingsGrid.setVisible(true);
                acresGrid.setVisible(true);
                
                acresLayerCheckBox.setSelected(true);
                acresLayerCheckBox.setDisable(true);
                acresGrid.setVisible(true);
            }
            // box is unchecked
            else
            {
                tilesGrid.setVisible(false);
                buildingsGrid.setVisible(false);
                acresGrid.setVisible(true);
                
                acresLayerCheckBox.setSelected(true);
                acresLayerCheckBox.setDisable(false);
                acresGrid.setVisible(true);
            }
        });
        acresLayerCheckBox.selectedProperty().addListener((observable, oldValue, newValue) ->
        {
            // box is checked
            if (newValue)
            {
                acresGrid.setVisible(true);
            }
            // box is unchecked
            else
            {
                acresGrid.setVisible(false);
            }
        });
    }
    
    // ============================================================================================================================================ \\
}
