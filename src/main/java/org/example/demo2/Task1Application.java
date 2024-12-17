package org.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Task1Application extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Task1.fxml"));
        primaryStage.setTitle("Перекидыватель слов");
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.setMinWidth(300);
        primaryStage.setMinHeight(200);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
