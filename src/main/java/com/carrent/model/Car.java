package com.carrent.model;



    public class Car {
        private String manifacturer;
        private String model;
        private double dailyCost;

        public Car(String make, String model, double dailyCost) {
            this.manifacturer= make;
            this.model = model;
            this.dailyCost = dailyCost;
        }

        public String getMake() { return manifacturer; }

        public void setMake(String make) { this.manifacturer = make; }

        public String getModel() { return model; }

        public void setModel(String model) { this.model = model; }

        public double getDailyCost() { return dailyCost; }

        public void setDailyCost(double dailyCost) { this.dailyCost = dailyCost; }


    }

