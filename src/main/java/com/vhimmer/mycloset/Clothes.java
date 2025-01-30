package com.vhimmer.mycloset;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Clothes {
    private static final String DATA_FILE = "clothes.json";
    private static final String IMAGE_DIR = "images/";

    private String name; // Name des Kleidungsstücks
    private List<String> categories; // Kategorien (z.B. "Sommer", "Business")
    private String imagePath; // Bildpfad

    public Clothes() {
        // Standardwerte setzen
        this.name = "Unbenannt";
        this.categories = new ArrayList<>();
        this.imagePath = "";
    }

    // Konstruktor
    public Clothes(String name, List<String> categories, String imagePath) {
        this.name = name;
        this.categories = categories;
        this.imagePath = imagePath;
    }

    // Getter und Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    // JSON-Daten speichern
    public static void saveClothingItems(List<Clothes> clothesList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(DATA_FILE)) {
            gson.toJson(clothesList, writer);
            System.out.println("✅ Daten erfolgreich gespeichert!");
        } catch (IOException e) {
            System.err.println("⚠ Fehler beim Speichern der Daten: " + e.getMessage());
        }
    }

    // JSON-Daten laden
    public static List<Clothes> loadClothingItems() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(DATA_FILE)) {
            Type listType = new TypeToken<List<Clothes>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            System.err.println("⚠ Fehler beim Laden der Daten: " + e.getMessage());
            return new ArrayList<>(); // Leere Liste, falls keine Daten vorhanden sind
        }
    }

    // Bild auswählen und speichern
    public static String chooseAndSaveImage(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Bild auswählen");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Bilder", "*.png", "*.jpg", "*.jpeg")
        );

        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            File targetDir = new File(IMAGE_DIR);
            if (!targetDir.exists()) {
                targetDir.mkdirs();
            }
            File targetFile = new File(targetDir, selectedFile.getName());
            try {
                Files.copy(selectedFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                return targetFile.getAbsolutePath();
            } catch (IOException e) {
                System.err.println("⚠ Fehler beim Speichern des Bildes: " + e.getMessage());
            }
        }
        return null;
    }

    // Neues Kleidungsstück hinzufügen
    public static void addClothingItem(Stage stage) {
        String imagePath = chooseAndSaveImage(stage);
        if (imagePath != null) {
            Clothes newClothing = new Clothes(
                    "Neues Kleidungsstück",
                    List.of("Sommer", "Business"), // Beispielkategorien
                    imagePath
            );

            List<Clothes> clothesList = loadClothingItems();
            clothesList.add(newClothing);
            saveClothingItems(clothesList);
        }
    }

    // Kleidungsstücke anzeigen
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("View your clothes");

        List<Clothes> clothesList = loadClothingItems(); // Lade gespeicherte Kleidungsstücke

        VBox layout = new VBox(10);
        for (Clothes item : clothesList) {
            Label nameLabel = new Label("Name: " + item.getName());
            Label categoriesLabel = new Label("Kategorien: " + String.join(", ", item.getCategories()));
            Label imageLabel = new Label("Bild: " + item.getImagePath());
            layout.getChildren().addAll(nameLabel, categoriesLabel, imageLabel);
        }

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}