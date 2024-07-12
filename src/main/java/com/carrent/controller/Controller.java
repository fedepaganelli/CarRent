package com.carrent.controller;

import com.carrent.model.Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

        // Aggiungi un listener per gestire la selezione della riga nella tabella
        carTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Imposta i campi di input con i valori dell'auto selezionata
                manufacturerField.setText(newValue.getManufacturer());
                modelField.setText(newValue.getModel());
                dailyCostField.setText(String.valueOf(newValue.getDailyCost()));
                transmissionField.setText(newValue.getTransmission());
                seatsField.setText(String.valueOf(newValue.getSeats()));
                sizeField.setText(newValue.getSize());
            }
        });
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

    @FXML
    private void handleRentCar() {
        try {
            // Rimuovi le macchine dalla lista delle auto disponibili (se necessario)
            // Esempio: carList.clear();

            // Carica il file FXML del dialogo di noleggio
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RentCar.fxml"));
            VBox rentCarPane = loader.load();

            // Crea una nuova finestra di dialogo
            Stage rentCarStage = new Stage();
            rentCarStage.setTitle("Rent Car");
            rentCarStage.initOwner(carTable.getScene().getWindow()); // Imposta la finestra principale come proprietaria
            rentCarStage.setScene(new Scene(rentCarPane));

            // Ottieni il controller del dialogo di noleggio e passagli l'auto selezionata
            RentCarController rentCarController = loader.getController();
            rentCarController.setDialogStage(rentCarStage);
            rentCarController.setSelectedCar(carTable.getSelectionModel().getSelectedItem());

            // Mostra il dialogo e attendi che l'utente interagisca
            rentCarStage.showAndWait();

            // Se l'utente ha confermato il noleggio, gestisci di conseguenza
            if (rentCarController.isRentClicked()) {
                // Esempio di output (da personalizzare con la tua logica di noleggio)
                System.out.println("Car rented successfully!");
            }

        } catch (IOException e) {
            e.printStackTrace();
            // Gestione dell'errore nel caricamento del dialogo
        }
    }
}
