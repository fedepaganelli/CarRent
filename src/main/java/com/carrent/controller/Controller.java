package com.carrent.controller;

import com.carrent.model.Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    @FXML private TableView<Car> carTable;
    @FXML private TableColumn<Car, String> manifacturerColumn;
    @FXML private TableColumn<Car, String> modelColumn;
    @FXML private TableColumn<Car, Double> dailyCostColumn;
    @FXML private TextField manifacturerField;
    @FXML private TextField modelField;
    @FXML private TextField dailyCostField;

    private ObservableList<Car> carList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        manifacturerColumn.setCellValueFactory(new PropertyValueFactory<>("manifacturer"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        dailyCostColumn.setCellValueFactory(new PropertyValueFactory<>("dailyCost"));
        carTable.setItems(carList);
    }

    @FXML
    private void addCar() {
        String make = manifacturerField.getText();
        String model = modelField.getText();
        double dailyCost = Double.parseDouble(dailyCostField.getText());
        Car car = new Car(make, model, dailyCost);
        carList.add(car);
        manifacturerField.clear();
        modelField.clear();
        dailyCostField.clear();
    }
}