package com.michaelgatesdev.OldLeaf.gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable
{
    @FXML
    BorderPane mainPane;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        
    }
    
    public BorderPane getMainPane()
    {
        return mainPane;
    }
}
