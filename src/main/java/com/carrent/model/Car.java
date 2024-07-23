package com.carrent.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Car {
    private String manufacturer;
    private String model;
    private double dailyCost;
    private String transmission;
    private int seats;
    private String size;
    private boolean isRented;
    private ImageView logo;

    public Car(String manufacturer, String model, double dailyCost, String transmission, int seats, String size, String logoPath) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.dailyCost = dailyCost;
        this.transmission = transmission;
        this.seats = seats;
        this.size = size;
        this.isRented = false;
        this.logo = new ImageView(new Image(getClass().getResourceAsStream(logoPath)));
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public double getDailyCost() {
        return dailyCost;
    }

    public String getTransmission() {
        return transmission;
    }

    public int getSeats() {
        return seats;
    }

    public String getSize() {
        return size;
    }

    public ImageView getLogo() {
        return logo;
    }


    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDailyCost(double dailyCost) {
        this.dailyCost = dailyCost;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public void setLogo(ImageView logo) {
        this.logo = logo;
    }


    public boolean isRented() {
        return isRented;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(dailyCost, car.dailyCost) == 0 && seats == car.seats && isRented == car.isRented && Objects.equals(manufacturer, car.manufacturer) && Objects.equals(model, car.model) && Objects.equals(transmission, car.transmission) && Objects.equals(size, car.size) && Objects.equals(logo, car.logo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model, dailyCost, transmission, seats, size, isRented, logo);
    }

    public String toString() {
        return manufacturer + " " + model;
    }

}