package com.carrent.controller;

import com.carrent.model.Car;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
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
        configureCarComboBox();
    }

    private void configureCarComboBox() {
        carComboBox.setCellFactory(new Callback<ListView<Car>, ListCell<Car>>() {
            @Override
            public ListCell<Car> call(ListView<Car> param) {
                return new ListCell<Car>() {
                    @Override
                    protected void updateItem(Car car, boolean empty) {
                        super.updateItem(car, empty);
                        if (empty || car == null) {
                            setText(null);
                        } else {
                            setText(car.getManufacturer() + " " + car.getModel() + (car.isRented() ? " (Rented)" : ""));
                        }
                    }
                };
            }
        });

        carComboBox.setButtonCell(new ListCell<Car>() {
            @Override
            protected void updateItem(Car car, boolean empty) {
                super.updateItem(car, empty);
                if (empty || car == null) {
                    setText("Select Car");
                } else {
                    setText(car.getManufacturer() + " " + car.getModel() + (car.isRented() ? " (Rented)" : ""));
                }
            }
        });
    }

    public void setSelectedCar(Car car) {
        carComboBox.setValue(car); // Imposta l'auto selezionata nella ComboBox
    }

    @FXML
    private void handleRentCar() {
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();

        if (startDate != null && endDate != null && carComboBox.getValue() != null) {
            Car selectedCar = carComboBox.getValue();

            if (selectedCar.isRented()) {
                System.out.println("Car is already rented.");
                // Puoi aggiungere un messaggio per informare l'utente
            } else {
                System.out.println("Renting car: " + selectedCar.getManufacturer() + " " + selectedCar.getModel() +
                        " from " + startDate + " to " + endDate);
                selectedCar.setRented(true);
                rentClicked = true;
                dialogStage.close();
            }
        } else {
            System.out.println("Please select a car and specify both start and end dates.");
        }
    }
}