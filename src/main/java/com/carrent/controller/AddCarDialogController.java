package com.carrent.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AddCarDialogController {

    @FXML
    private DialogPane dialogPane;

    @FXML
    private TextField modelField;

    @FXML
    private TextField dailyCostField;

    @FXML
    private ComboBox<String> manufacturerComboBox;

    @FXML
    private ComboBox<String> transmissionComboBox;

    @FXML
    private ComboBox<String> seatsComboBox;

    @FXML
    private ComboBox<String> sizeComboBox;

    private Stage dialogStage;
    private boolean okClicked = false;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (validateInput()) {
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    public String getModel() {
        return modelField.getText();
    }

    public double getDailyCost() {
        return Double.parseDouble(dailyCostField.getText());
    }

    public String getManufacturer() {
        return manufacturerComboBox.getValue();
    }

    public String getTransmission() {
        return transmissionComboBox.getValue();
    }

    public int getSeats() {
        return Integer.parseInt(seatsComboBox.getValue());
    }

    public String getSize() {
        return sizeComboBox.getValue();
    }

    private boolean validateInput() {
        return true;    //il progetto non prevede la validazione dell'input
    }
}