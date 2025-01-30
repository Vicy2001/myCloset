package com.vhimmer.mycloset;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyCloset extends Application {
    private static Scene primaryScene;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fashion Manager");

        // startscreen buttons
        Button btnOutfits = new Button("View Outfits");
        Button btnClothes = new Button("View Clothes");
        Button btnNewClothes = new Button("Add New Clothes");
        Button btnSettings = new Button("Settings");

        btnOutfits.getStyleClass().add("main-button");
        btnClothes.getStyleClass().add("main-button");
        btnNewClothes.getStyleClass().add("main-button");
        btnSettings.getStyleClass().add("main-button");

        // event-handler to open new windows
        btnOutfits.setOnAction(e -> new Outfits().show());
        btnClothes.setOnAction(e -> new Clothes().show());
        btnNewClothes.setOnAction(e -> new AddNewClothes().show());
        btnSettings.setOnAction(e -> new Settings().show());

        // button layout
        VBox layout = new VBox(10, btnOutfits, btnClothes, btnNewClothes, btnSettings);
        layout.setStyle("-fx-alignment: center; -fx-padding: 20px;");

        // generate and load scene
        primaryScene = new Scene(layout, 300, 250);
        applyTheme(primaryScene);  // Theme beim Start setzen

        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }

    private static void applyTheme(Scene scene) {
        scene.getStylesheets().clear();
        String themePath = Settings.getCurrentTheme();
        String cssPath = MyCloset.class.getResource(themePath) != null ? MyCloset.class.getResource(themePath).toExternalForm() : null;

        if (cssPath != null) {
            System.out.println("🎨 Theme loading: " + themePath);
            scene.getStylesheets().add(cssPath);
        } else {
            System.out.println("⚠ Fehler: CSS konnte nicht geladen werden! Path: " + themePath);
        }
    }

    public static void updateTheme(String themePath) {
        if (primaryScene != null) {
            primaryScene.getStylesheets().clear();
            String cssPath = MyCloset.class.getResource(themePath) != null ? MyCloset.class.getResource(themePath).toExternalForm() : null;
            if (cssPath != null) {
                primaryScene.getStylesheets().add(cssPath);
            } else {
                System.out.println("⚠ Fehler: CSS-Datei nicht gefunden! Pfad: " + themePath);
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}