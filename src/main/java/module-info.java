module com.carrent.carrent {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.carrent.carrent to javafx.fxml;
    exports com.carrent.carrent;
}