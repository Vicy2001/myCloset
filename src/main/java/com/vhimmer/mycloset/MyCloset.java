package com.vhimmer.mycloset;

import com.vhimmer.mycloset.Theme;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyCloset extends Application {
    private static Scene primaryScene;

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

        primaryScene = new Scene(layout, 300, 250);

        // apply theme
        applyTheme(primaryScene);

        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }

    public static void applyTheme(Scene scene) {
        scene.getStylesheets().clear();
        String cssPath = MyCloset.class.getResource(Theme.getCurrentTheme().getStylesheetPath()).toExternalForm();
        if (cssPath != null) {
            scene.getStylesheets().add(cssPath);
        } else {
            System.out.println("⚠ Fehler: Stylesheet konnte nicht geladen werden!");
        }
    }

    public static Scene getPrimaryScene() {
        return primaryScene;
    }

    public static void main(String[] args) {
        launch();
    }
}