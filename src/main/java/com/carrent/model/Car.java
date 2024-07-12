package com.carrent.model;


public class Car {
    private String manufacturer;
    private String model;
    private double dailyCost;
    private String transmission; // automatico o manuale
    private int seats;
    private double length;
    private double width;


    public Car(String manufacturer, String model, double dailyCost, String transmission, int seats, double length, double width) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.dailyCost = dailyCost;
        this.transmission = transmission;
        this.seats = seats;
        this.length = length;
        this.width = width;
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

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}

