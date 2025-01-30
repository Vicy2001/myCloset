package com.vhimmer.mycloset;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Settings {

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Settings");

        // themes
        Button themesButton = new Button("Themes");
        themesButton.setOnAction(e -> new ThemeSettings().show()); // new window for theme

        // TODO: language Button

        // set buttons as "main-button" for stylesheet
        themesButton.getStyleClass().add("main-button");

        // settings layout
        VBox layout = new VBox(10, themesButton);
        layout.setStyle("-fx-alignment: center;");
        Scene scene = new Scene(layout, 300, 150);
        applyTheme(scene);
        stage.setScene(scene);
        stage.show();
    }

    private void applyTheme(Scene scene) {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(MyCloset.class.getResource(Theme.getCurrentTheme().getStylesheetPath()).toExternalForm());
    }
}