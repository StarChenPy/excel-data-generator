package xyz.starsdust.exceldatagenerator.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Scene implements Initializable {
    @FXML
    private Label version;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        version.setText("v1.0");
    }
}
