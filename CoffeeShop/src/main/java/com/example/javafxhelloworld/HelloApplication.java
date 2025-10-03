package com.example.javafxhelloworld;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("welcome.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Coffee Shop!");
        stage.setScene(scene);
        stage.show();
    }

    public static void switchScene(String fxmlFile, String name) throws Exception {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        
        // https://stackoverflow.com/questions/14187963/passing-parameters-javafx-fxml
        // gets the controller so you can call methods
        HelloController controller = loader.getController();
        controller.setName(name);

    }

    public static void main(String[] args) {
        launch();
    }
}