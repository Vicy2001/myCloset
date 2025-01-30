package com.vhimmer.mycloset;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Clothes {
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("View your clothes");

        Label label = new Label("Here are all your clothes");

        VBox layout = new VBox(10, label);
        Scene scene = new Scene(layout, 400, 300);

        stage.setScene(scene);
        stage.show();
    }
}
