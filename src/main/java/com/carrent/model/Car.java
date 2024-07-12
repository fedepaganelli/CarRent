package com.carrent.model;



    public class Car {
        private String manufacturer;
        private String model;
        private double dailyCost;

        public Car(String manufacturer, String model, double dailyCost) {
            this.manufacturer= manufacturer;
            this.model = model;
            this.dailyCost = dailyCost;
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
    }

