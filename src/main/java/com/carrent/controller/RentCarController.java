package com.carrent.controller;

import com.carrent.model.Car;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.time.LocalDate;

public class RentCarController {

    @FXML
    private ComboBox<Car> carComboBox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private Label errorLabel; // New label for displaying errors

    private Stage dialogStage;
    private boolean rentClicked = false;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isRentClicked() {
        return rentClicked;
    }

    public void setAvailableCars(ObservableList<Car> cars) {
        carComboBox.setItems(cars);
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
        carComboBox.setValue(car);
    }

    @FXML
    private void handleRentCar(ActionEvent event) {
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();
        Car selectedCar = carComboBox.getValue();
        if (validateInput()) {
            if (selectedCar.isRented()) {
                errorLabel.setText("Car is already rented.");
            } else {
                double dailyCost = selectedCar.getDailyCost();
                int numberOfDays = (int) startDate.until(endDate).getDays() + 1;
                double totalCost = dailyCost * numberOfDays;

                System.out.println("Total rental cost for " + selectedCar.getManufacturer() + " " + selectedCar.getModel() +
                        " from " + startDate + " to " + endDate + ": €" + totalCost);

                selectedCar.setRented(true);
                rentClicked = true;
                dialogStage.close();
            }
        } else {
            event.consume();
        }
    }

    private boolean validateInput() {
        String errorMessage = "";
        boolean isValid = true;

        if (startDatePicker.getValue() == null) {
            errorMessage += "No start date specified!\n";
            startDatePicker.setStyle("-fx-border-color: red;");
            isValid = false;
        } else {
            startDatePicker.setStyle("");
        }

        if (endDatePicker.getValue() == null) {
            errorMessage += "No end date specified!\n";
            endDatePicker.setStyle("-fx-border-color: red;");
            isValid = false;
        } else {
            endDatePicker.setStyle("");
        }

        if((startDatePicker.getValue() != null && endDatePicker.getValue() != null) && (startDatePicker.getValue().isBefore(LocalDate.now()) || startDatePicker.getValue().isAfter(endDatePicker.getValue()))) {
            errorMessage += "Invalid dates!\n";
            startDatePicker.setStyle("-fx-border-color: red;");
            endDatePicker.setStyle("-fx-border-color: red;");
            isValid = false;
        } else if (startDatePicker.getValue() == null){
            startDatePicker.setStyle("-fx-border-color: red;");
        } else if (endDatePicker.getValue() == null){
            endDatePicker.setStyle("-fx-border-color: red;");
        } else {
            startDatePicker.setStyle("");
            endDatePicker.setStyle("");
        }

        if (!isValid) {
            errorLabel.setText(errorMessage);
        } else {
            errorLabel.setText("");
        }

        return isValid;
    }
}