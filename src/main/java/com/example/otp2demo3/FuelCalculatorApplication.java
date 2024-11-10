package com.example.otp2demo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FuelCalculatorApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Load FXML and initialize the UI
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();

        // Set up the scene and the stage
        primaryStage.setTitle("hello!");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
