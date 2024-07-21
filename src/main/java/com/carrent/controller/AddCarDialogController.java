package com.carrent.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AddCarDialogController {

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

    @FXML
    private Label errorLabel;

    private Stage dialogStage;

    @FXML
    public void setDialogStage(Stage dialogStage, DialogPane dialogPane) {
        this.dialogStage = dialogStage;

        Button okButton = (Button) dialogPane.lookupButton(ButtonType.OK);
        okButton.addEventFilter(ActionEvent.ACTION, this::handleOk);
    }

    @FXML
    private void handleOk(ActionEvent event) {
        if (validateInput()) {
            dialogStage.close();
        } else {
            event.consume();
            errorLabel.setText("Please correct the invalid fields.");
        }
    }

    public String getModel() {
        return modelField.getText();
    }

    public double getDailyCost() {
        try {
            return Double.parseDouble(dailyCostField.getText());
        } catch (NumberFormatException | NullPointerException e){
            return -1;
        }
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
        boolean isValid = true;

        if (modelField.getText() == null || modelField.getText().isEmpty()) {
            isValid = false;
            modelField.setStyle("-fx-border-color: red;");
        } else {
            modelField.setStyle("");
        }


        if (dailyCostField.getText() == null || dailyCostField.getText().isEmpty() || getDailyCost() < 0) {
            isValid = false;
            dailyCostField.setStyle("-fx-border-color: red;");
        } else {
            dailyCostField.setStyle("");
        }


        if (manufacturerComboBox.getValue() == null || manufacturerComboBox.getValue().isEmpty()) {
            isValid = false;
            manufacturerComboBox.setStyle("-fx-border-color: red;");
        } else {
            manufacturerComboBox.setStyle("");
        }


        if (transmissionComboBox.getValue() == null || transmissionComboBox.getValue().isEmpty()) {
            isValid = false;
            transmissionComboBox.setStyle("-fx-border-color: red;");
        } else {
            transmissionComboBox.setStyle("");
        }

        if (seatsComboBox.getValue() == null || seatsComboBox.getValue().isEmpty()) {
            isValid = false;
            seatsComboBox.setStyle("-fx-border-color: red;");
        } else {
            seatsComboBox.setStyle("");
        }

        if (sizeComboBox.getValue() == null || sizeComboBox.getValue().isEmpty()) {
            isValid = false;
            sizeComboBox.setStyle("-fx-border-color: red;");
        } else {
            sizeComboBox.setStyle("");
        }

        return isValid;
    }
}