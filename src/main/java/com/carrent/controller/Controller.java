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
    private TableColumn<Car, Double> lengthColumn;
    @FXML
    private TableColumn<Car, Double> widthColumn;
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
    private TextField lengthField;
    @FXML
    private TextField widthField;

    private ObservableList<Car> carList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        manufacturerColumn.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        dailyCostColumn.setCellValueFactory(new PropertyValueFactory<>("dailyCost"));
        transmissionColumn.setCellValueFactory(new PropertyValueFactory<>("transmission"));
        seatsColumn.setCellValueFactory(new PropertyValueFactory<>("seats"));
        lengthColumn.setCellValueFactory(new PropertyValueFactory<>("length"));
        widthColumn.setCellValueFactory(new PropertyValueFactory<>("width"));

        carTable.setItems(carList);
    }

    @FXML
    private void addCar() {
        String manufacturer = manufacturerField.getText();
        String model = modelField.getText();
        double dailyCost = Double.parseDouble(dailyCostField.getText());
        String transmission = transmissionField.getText();
        int seats = Integer.parseInt(seatsField.getText());
        double length = Double.parseDouble(lengthField.getText());
        double width = Double.parseDouble(widthField.getText());

        Car car = new Car(manufacturer, model, dailyCost, transmission, seats, length, width);
        carList.add(car);

        manufacturerField.clear();
        modelField.clear();
        dailyCostField.clear();
        transmissionField.clear();
        seatsField.clear();
        lengthField.clear();
        widthField.clear();
    }
}
