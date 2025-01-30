package com.vhimmer.mycloset;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyCloset extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Closet Manager");

        // Buttons on startscreen
        Button btnOutfits = new Button("view outfits");
        Button btnClothes = new Button("view clothes");
        Button btnNewClothes = new Button("add new clothes");
        Button btnSettings = new Button("Settings");

        // Event-Handler to open windows
        btnOutfits.setOnAction(e -> new Outfits().show());
        btnClothes.setOnAction(e -> new Clothes().show());
        btnNewClothes.setOnAction(e -> new AddNewClothes().show());
        btnSettings.setOnAction(actionEvent -> new Settings().show());

        btnOutfits.getStyleClass().add("main-button");
        btnClothes.getStyleClass().add("main-button");
        btnNewClothes.getStyleClass().add("main-button");
        btnSettings.getStyleClass().add("main-button");

        // Layout for buttons
        VBox layout = new VBox(10, btnOutfits, btnClothes, btnNewClothes, btnSettings);
        layout.setStyle("-fx-alignment: center; -fx-padding: 20px;");

        Scene scene = new Scene(layout, 300, 200);

        applyStyle(scene);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}