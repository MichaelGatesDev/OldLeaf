package com.michaelgatesdev.OldLeaf.gui.controllers.mapEditor;

import com.michaelgatesdev.OldLeaf.Main;
import com.michaelgatesdev.OldLeaf.gui.components.grid.GameTilesGrid;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class MapEditorItemsPanelController implements Initializable
{
    // ============================================================================================================================================ \\
    
    private static final Logger logger = Logger.getLogger(MapEditorItemsPanelController.class);
    
    @FXML
    public Accordion itemCatalogAccordion;
    
    // ============================================================================================================================================ \\
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        itemCatalogAccordion.getPanes().clear();
        
        Map<String, Map<Short, String>> categories = Main.getInstance().getGameItemCategories();
        for (String key : categories.keySet())
        {
            itemCatalogAccordion.getPanes().add(this.createCategoryPane(key, new ArrayList<>(categories.get(key).values())));
        }
    }
    
    // ============================================================================================================================================ \\
    
    
    private TitledPane createCategoryPane(String title, List<String> strings)
    {
        TitledPane pane = new TitledPane();
        pane.setText(title);
        
        ListView<String> view = new ListView<>();
        view.getItems().addAll(strings);
        pane.setContent(view);
        
        view.setOnMouseClicked(event ->
        {
            String item = view.getSelectionModel().getSelectedItem();
            
            GameTilesGrid grid = (GameTilesGrid) itemCatalogAccordion.getScene().lookup("GameTilesGrid");
            grid.setSelectedItem(Main.getInstance().getItemFromName(item));
        });
        
        return pane;
    }
    
    // ============================================================================================================================================ \\
}
