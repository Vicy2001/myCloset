package com.vhimmer.mycloset;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ThemeSettings {

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Theme Settings");

        // Dropdown for themes
        ComboBox<Theme> themeSelector = new ComboBox<>();
        themeSelector.getItems().addAll(Theme.values());
        themeSelector.setValue(Theme.getCurrentTheme());

        // apply theme
        Button applyButton = new Button("Apply Theme");
        applyButton.setOnAction(e -> {
            Theme selectedTheme = themeSelector.getValue();
            if (selectedTheme != null) {
                Theme.setCurrentTheme(selectedTheme);
                MyCloset.applyTheme(MyCloset.getPrimaryScene());
                applyTheme(stage.getScene());
            }
        });

        // Layout
        VBox layout = new VBox(10, themeSelector, applyButton);
        Scene scene = new Scene(layout, 300, 150);
        applyTheme(scene); // Aktuelles Theme anwenden
        stage.setScene(scene);
        stage.show();
    }

    private void applyTheme(Scene scene) {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(MyCloset.class.getResource(Theme.getCurrentTheme().getStylesheetPath()).toExternalForm());
    }
}