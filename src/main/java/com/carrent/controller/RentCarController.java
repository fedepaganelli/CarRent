package com.carrent.controller;

import com.carrent.model.Car;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.time.LocalDate;

public class RentCarController {

    @FXML
    private ComboBox<Car> carComboBox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    private Stage dialogStage;
    private boolean rentClicked = false;

    private ObservableList<Car> availableCars;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isRentClicked() {
        return rentClicked;
    }

    public void setAvailableCars(ObservableList<Car> cars) {
        this.availableCars = cars;
        carComboBox.setItems(availableCars);
    }

    public void setSelectedCar(Car car) {
        carComboBox.setValue(car); // Imposta l'auto selezionata nella ComboBox
    }

    @FXML
    private void handleRentCar() {
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();

        if (startDate != null && endDate != null && carComboBox.getValue() != null) {
            // Esempio di output (da personalizzare con la tua logica di noleggio)
            Car selectedCar = carComboBox.getValue();
            System.out.println("Renting car: " + selectedCar.getManufacturer() + " " + selectedCar.getModel() +
                    " from " + startDate + " to " + endDate);
            rentClicked = true;
            dialogStage.close();
        } else {
            // Gestisci il caso in cui non siano selezionate tutte le opzioni necessarie
            System.out.println("Please select a car and specify both start and end dates.");
        }
    }
}
