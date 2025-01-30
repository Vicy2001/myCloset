package com.vhimmer.mycloset;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Settings {

    private static String currentTheme = "/light.css"; // lightmode as default

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Settings");

        // Dropdown menu for Themes
        ComboBox<String> themeSelector = new ComboBox<>();
        themeSelector.getItems().addAll("light", "dark", "pink", "blue");
        themeSelector.setValue("light");

        Button applyButton = new Button("apply theme");
        applyButton.setOnAction(e -> {
            String selectedTheme = themeSelector.getValue();
            applyTheme(selectedTheme);
        });

        VBox layout = new VBox(10, themeSelector, applyButton);
        Scene scene = new Scene(layout, 300, 150);
        stage.setScene(scene);
        stage.show();
    }

    private void applyTheme(String themeName) {
        switch (themeName.toLowerCase()) { // Verarbeite Eingabe unabhängig von Groß-/Kleinschreibung
            case "dark":
                currentTheme = "/dark.css";
                break;
            case "blue":
                currentTheme = "/blue.css";
                break;
            case "pink":
                currentTheme = "/pink.css";
                break;
            default:
                currentTheme = "/light.css"; // Standard ist Light-Theme
        }

        System.out.println("🔄 Theme changed to: " + currentTheme);
        MyCloset.updateTheme(currentTheme);
    }

    public static String getCurrentTheme() {
        return currentTheme;
    }
}
