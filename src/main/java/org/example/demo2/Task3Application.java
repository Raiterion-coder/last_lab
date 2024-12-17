package org.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Task3Application extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Task3.fxml"));
        primaryStage.setTitle("Корзина в пятёрочке");
        primaryStage.setScene(new Scene(root, 350, 250));
        primaryStage.setMinWidth(790);
        primaryStage.setMinHeight(250);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
