package com.carrent.controller;

import com.carrent.model.Car;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private TableColumn<Car, String> statusColumn;
    @FXML
    private TableColumn<Car, ImageView> logoColumn;
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
    @FXML
    private ImageView logoImageView;

    private final ObservableList<Car> carList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        manufacturerColumn.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        dailyCostColumn.setCellValueFactory(new PropertyValueFactory<>("dailyCost"));
        transmissionColumn.setCellValueFactory(new PropertyValueFactory<>("transmission"));
        seatsColumn.setCellValueFactory(new PropertyValueFactory<>("seats"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        statusColumn.setCellValueFactory(cellData -> {
            boolean isRented = cellData.getValue().isRented();
            return new ReadOnlyStringWrapper(isRented ? "Rented" : "Available");
        });
        Image logoImage = new Image(getClass().getResourceAsStream("/com/carrent/icons/car_rental_logo.jpeg"));
        logoImageView.setImage(logoImage);

        logoColumn.setCellValueFactory(new PropertyValueFactory<>("logo"));
        logoColumn.setCellFactory(column -> new TableCell<>() {
            private final ImageView imageView = new ImageView();

            @Override
            protected void updateItem(ImageView item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    imageView.setImage(item.getImage());
                    imageView.setFitWidth(50);
                    imageView.setFitHeight(50);
                    setGraphic(imageView);
                }
            }
        });

        carTable.setItems(carList);

        addDefaultCars();

    }


    private void addDefaultCars() {
        carList.add(new Car("Audi", "A4", 50.0, "Automatic", 5, "Medium", getLogoPathForManufacturer("audi")));
        carList.add(new Car("BMW", "X3", 60.0, "Automatic", 5, "Large", getLogoPathForManufacturer("bmw")));
        carList.add(new Car("Mercedes-Benz", "C-Class", 55.0, "Automatic", 5, "Medium", getLogoPathForManufacturer("mercedes-benz")));
        carList.add(new Car("Toyota", "Camry", 45.0, "Automatic", 5, "Medium", getLogoPathForManufacturer("toyota")));
        carList.add(new Car("Honda", "Accord", 45.0, "Automatic", 5, "Medium", getLogoPathForManufacturer("honda")));
        carList.add(new Car("Ford", "Mustang", 70.0, "Automatic", 4, "Medium", getLogoPathForManufacturer("ford")));
        carList.add(new Car("Chevrolet", "Camaro", 65.0, "Automatic", 4, "Medium", getLogoPathForManufacturer("chevrolet")));
        carList.add(new Car("Volkswagen", "Golf", 40.0, "Manual", 5, "Small", getLogoPathForManufacturer("volkswagen")));
        carList.add(new Car("Nissan", "Altima", 50.0, "Automatic", 5, "Medium", getLogoPathForManufacturer("nissan")));
        carList.add(new Car("Hyundai", "Sonata", 45.0, "Automatic", 5, "Medium", getLogoPathForManufacturer("hyundai")));
    }


    @FXML
    private void handleAddCar() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCarDialog.fxml"));
            DialogPane dialogPane = loader.load();

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(dialogPane);

            AddCarDialogController controller = loader.getController();
            Stage stage = (Stage) dialogPane.getScene().getWindow();
            stage.setTitle("Add Car");
            controller.setDialogStage(stage, dialogPane);

            Optional<ButtonType> result = dialog.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {

                String manufacturer = controller.getManufacturer();
                String model = controller.getModel();
                double dailyCost = controller.getDailyCost();
                String transmission = controller.getTransmission();
                int seats = controller.getSeats();
                String size = controller.getSize();
                String logoPath = getLogoPathForManufacturer(manufacturer);

                Car car = new Car(manufacturer, model, dailyCost, transmission, seats, size, logoPath);

                carList.add(car);

                manufacturerField.clear();
                modelField.clear();
                dailyCostField.clear();
                transmissionField.clear();
                seatsField.clear();
                sizeField.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getLogoPathForManufacturer(String manufacturer) {
        return switch (manufacturer.toLowerCase()) {
            case "audi" -> "/com/carrent/icons/audi.png";
            case "bmw" -> "/com/carrent/icons/bmw.png";
            case "mercedes-benz" -> "/com/carrent/icons/mercedes-benz.png";
            case "toyota" -> "/com/carrent/icons/toyota.png";
            case "honda" -> "/com/carrent/icons/honda.png";
            case "fiat" -> "/com/carrent/icons/fiat.png";
            case "ford" -> "/com/carrent/icons/ford.png";
            case "chevrolet" -> "/com/carrent/icons/chevrolet.png";
            case "volkswagen" -> "/com/carrent/icons/volkswagen.png";
            case "nissan" -> "/com/carrent/icons/nissan.png";
            case "hyundai" -> "/com/carrent/icons/hyundai.png";
            case "kia" -> "/com/carrent/icons/kia.png";
            case "mazda" -> "/com/carrent/icons/mazda.png";
            case "subaru" -> "/com/carrent/icons/subaru.png";
            case "volvo" -> "/com/carrent/icons/volvo.png";
            case "porsche" -> "/com/carrent/icons/porsche.png";
            case "ferrari" -> "/com/carrent/icons/ferrari.png";
            case "lamborghini" -> "/com/carrent/icons/lamborghini.png";
            case "maserati" -> "/com/carrent/icons/maserati.png";
            case "jaguar" -> "/com/carrent/icons/jaguar.png";
            case "land rover" -> "/com/carrent/icons/land_rover.png";
            default -> "/com/carrent/icons/default_logo.png";
        };
    }

    @FXML
    private void handleRentCar() {
        Car selectedCar = carTable.getSelectionModel().getSelectedItem();
        if (selectedCar != null && !selectedCar.isRented()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("RentCar.fxml"));
                VBox rentCarPane = loader.load();

                Stage rentCarStage = new Stage();
                rentCarStage.setTitle("Rent Car");
                rentCarStage.initOwner(carTable.getScene().getWindow());
                rentCarStage.setScene(new Scene(rentCarPane));

                rentCarStage.setResizable(false);

                RentCarController rentCarController = loader.getController();
                rentCarController.setDialogStage(rentCarStage);
                rentCarController.setSelectedCar(selectedCar);

                rentCarStage.showAndWait();

                if (rentCarController.isRentClicked()) {
                    selectedCar.setRented(true);
                    carTable.refresh();
                    System.out.println("Car rented successfully!");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please select an available car to rent.");
        }
    }

    @FXML
    private void handleSearchCar() {
        String manufacturer = manufacturerField.getText().toLowerCase();
        String model = modelField.getText().toLowerCase();
        String dailyCostString = dailyCostField.getText().toLowerCase();
        String transmission = transmissionField.getText().toLowerCase();
        String seatsString = seatsField.getText().toLowerCase();
        String size = sizeField.getText().toLowerCase();

        double dailyCost = -1;
        int seats = -1;

        try {
            if (!dailyCostString.isEmpty()) {
                dailyCost = Double.parseDouble(dailyCostString);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Daily Cost is not a valid value.");
        }

        try {
            if (!seatsString.isEmpty()) {
                seats = Integer.parseInt(seatsString);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Seats is not a valid value.");
        }

        ObservableList<Car> filteredList = FXCollections.observableArrayList();

        for (Car car : carList) {
            if ((manufacturer.isEmpty() || car.getManufacturer().toLowerCase().contains(manufacturer)) &&
                    (model.isEmpty() || car.getModel().toLowerCase().contains(model)) &&
                    (dailyCost == -1 || car.getDailyCost() <= dailyCost) &&
                    (transmission.isEmpty() || car.getTransmission().toLowerCase().contains(transmission)) &&
                    (seats == -1 || car.getSeats() == seats) &&
                    (size.isEmpty() || car.getSize().toLowerCase().contains(size))) {
                filteredList.add(car);
            }
        }

        carTable.setItems(filteredList);

        manufacturerField.clear();
        modelField.clear();
        dailyCostField.clear();
        transmissionField.clear();
        seatsField.clear();
        sizeField.clear();

    }
}