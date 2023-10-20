package xyz.starsdust.exceldatagenerator.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import xyz.starsdust.exceldatagenerator.javafx.NoRoundRadioButton;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    @FXML
    private Label versionText;
    @FXML
    private NoRoundRadioButton generateDataButton;
    @FXML
    private NoRoundRadioButton submitDataButton;
    @FXML
    private TextArea infoTextArea;
    @FXML
    private Pane contentPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.versionText.setText("v1.0");

        ToggleGroup tg = new ToggleGroup();
        this.generateDataButton.setText("生成数据");
        this.generateDataButton.setFont(Font.font(16));
        this.generateDataButton.setOnAction(event -> {

        });
        this.generateDataButton.setToggleGroup(tg);

        this.submitDataButton.setText("提交数据");
        this.submitDataButton.setFont(Font.font(16));
        this.submitDataButton.setOnAction(event -> {

        });
        this.submitDataButton.setToggleGroup(tg);

        this.generateDataButton.fire();
    }
}
