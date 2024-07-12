package com.carrent.model;



    public class Car {
        private String manifacturer;
        private String model;
        private double dailyCost;

        public Car(String manifacturer, String model, double dailyCost) {
            this.manifacturer= manifacturer;
            this.model = model;
            this.dailyCost = dailyCost;
        }

        public String getManifacturer() {
            return manifacturer;
        }

        public void setManifacturer(String manifacturer) {
            this.manifacturer = manifacturer;
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

