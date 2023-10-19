package xyz.starsdust.exceldatagenerator.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import lombok.extern.slf4j.Slf4j;
import xyz.starsdust.exceldatagenerator.javafx.NoRoundRadioButton;

import java.net.URL;
import java.util.ResourceBundle;

@Slf4j
public class RootController implements Initializable {
    @FXML
    private Label versionText;
    @FXML
    private NoRoundRadioButton generateDataButton;
    @FXML
    private NoRoundRadioButton submitDataButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.versionText.setText("v1.0");

        ToggleGroup tg = new ToggleGroup();
        this.generateDataButton.setText("生成数据");
        this.generateDataButton.setFont(Font.font(16));
        this.generateDataButton.setOnAction(event -> {
            log.info("生成被选择");
        });
        this.generateDataButton.setToggleGroup(tg);

        this.submitDataButton.setText("提交数据");
        this.submitDataButton.setFont(Font.font(16));
        this.submitDataButton.setOnAction(event -> {
            log.info("提交被选择");
        });
        this.submitDataButton.setToggleGroup(tg);

        this.generateDataButton.fire();
    }
}
