module com.vhimmer.mycloset {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.vhimmer.mycloset to javafx.fxml;
    exports com.vhimmer.mycloset;
}