package com.carrent.controller;

import com.carrent.model.Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Optional;

public class Controller {
    @FXML
    private TableView<Car> carTable;
    @FXML
    private TableColumn<Car, String> manufacturerColumn;
    @FXML
    private TableColumn<Car, String> modelColumn;
    @FXML
    private TableColumn<Car, Double> dailyCostColumn;
    @FXML
    private TableColumn<Car, String> transmissionColumn;
    @FXML
    private TableColumn<Car, Integer> seatsColumn;
    @FXML
    private TableColumn<Car, String> sizeColumn;
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

    private ObservableList<Car> carList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        manufacturerColumn.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        dailyCostColumn.setCellValueFactory(new PropertyValueFactory<>("dailyCost"));
        transmissionColumn.setCellValueFactory(new PropertyValueFactory<>("transmission"));
        seatsColumn.setCellValueFactory(new PropertyValueFactory<>("seats"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));

        carTable.setItems(carList);
    }

    @FXML
    private void handleAddCar() {
        try {
            // Carica il file FXML del dialogo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCarDialog.fxml"));
            DialogPane dialogPane = loader.load();

            // Crea un nuovo dialogo
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(dialogPane);

            // Ottieni il controller del dialogo e impostane la finestra di dialogo
            AddCarDialogController controller = loader.getController();
            Stage stage = (Stage) dialogPane.getScene().getWindow();
            controller.setDialogStage(stage);

            // Mostra il dialogo e attendi la risposta
            Optional<ButtonType> result = dialog.showAndWait();

            // Gestisci la risposta
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Esegui l'aggiunta dell'auto usando i dati dal controller del dialogo
                String manufacturer = controller.getManufacturer();
                String model = controller.getModel();
                double dailyCost = controller.getDailyCost();
                String transmission = controller.getTransmission();
                int seats = controller.getSeats();
                String size = controller.getSize();

                // Crea un oggetto Car con i dati ottenuti
                Car car = new Car(manufacturer, model, dailyCost, transmission, seats, size);

                // Aggiungi l'auto alla lista e aggiorna la TableView
                carList.add(car);

                // Pulisci i campi di input
                manufacturerField.clear();
                modelField.clear();
                dailyCostField.clear();
                transmissionField.clear();
                seatsField.clear();
                sizeField.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
            // Gestione dell'errore nel caricamento del dialogo
        }
    }
}
