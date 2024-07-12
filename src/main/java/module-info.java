module com.carrent.carrent {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.carrent to javafx.fxml;
    exports com.carrent;
    exports com.carrent.model;
    opens com.carrent.model to javafx.fxml;
    exports com.carrent.controller;
    opens com.carrent.controller to javafx.fxml;
}