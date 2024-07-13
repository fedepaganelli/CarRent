package com.carrent.model;


public class Car {
    private String manufacturer;
    private String model;
    private double dailyCost;
    private String transmission; // automatico o manuale
    private int seats;
    private String size;
    private boolean isRented; // Aggiunto attributo


    public Car(String manufacturer, String model, double dailyCost, String transmission, int seats, String size) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.dailyCost = dailyCost;
        this.transmission = transmission;
        this.seats = seats;
        this.size = size;
        this.isRented = false; // Inizialmente l'auto non è noleggiata
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getDailyCost() {
        return dailyCost;
    }

    public void setDailyCost(double dailyCost) {
        this.dailyCost = dailyCost;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String toString() {
        return manufacturer + " " + model;
    }
}