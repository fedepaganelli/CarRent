package com.carrent.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCarDialogController {

    @FXML
    private DialogPane dialogPane;

    @FXML
    private TextField manufacturerField;

    @FXML
    private TextField modelField;

    @FXML
    private TextField dailyCostField;

    @FXML
    private TextField transmissionField;

    @FXML
    private TextField seatsField;

    @FXML
    private TextField sizeField;

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

    public String getManufacturer() {
        return manufacturerField.getText();
    }

    public String getModel() {
        return modelField.getText();
    }

    public double getDailyCost() {
        return Double.parseDouble(dailyCostField.getText());
    }

    public String getTransmission() {
        return transmissionField.getText();
    }

    public int getSeats() {
        return Integer.parseInt(seatsField.getText());
    }

    public String getSize() {
        return sizeField.getText();
    }

    private boolean validateInput() {
        // Implement your validation logic here
        return true; // Replace with actual validation
    }
}

