package xyz.starsdust.exceldatagenerator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import xyz.starsdust.exceldatagenerator.util.Config;

import java.util.Objects;

public class ExcelDataGenerator extends Application {
//    private static void test() {
//        String inputPath = Config.getInstance().getConfig().getInputPath();
//        EasyExcel.read(inputPath, new ReadExcel()).sheet().doRead();
//    }

    public static void application(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Config.getInstance().loadConfig("/config.json");

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/scene.fxml")));
        primaryStage.setTitle("数据提交器");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }
}
