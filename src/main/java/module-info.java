module com.vhimmer.mycloset {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens com.vhimmer.mycloset to javafx.fxml, com.google.gson;
    exports com.vhimmer.mycloset;
}