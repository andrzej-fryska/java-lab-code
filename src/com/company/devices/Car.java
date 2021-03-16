package com.company.devices;

public class Car extends Device {

    final String type;
    public String color;
    public Integer maxSpeed;
    public Double price;


    public Car(String manufacturer, String model, String type, Integer yearOfProduction){
        this.manufacturer = manufacturer;
        this.model = model;
        this.type = type;
        this.color = "";
        this.yearOfProduction = yearOfProduction;
    }


    public String toString(){
        return manufacturer + " " + model + " " + type + " " + yearOfProduction;
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Car car = (Car) obj;
        return this.manufacturer.equals(car.manufacturer) && this.model.equals(car.model) && this.type.equals(car.type)
                && this.color.equals(car.color) && this.maxSpeed == car.maxSpeed && this.price == car.price
                && this.yearOfProduction == car.yearOfProduction;
    }


    public void turnOn(){
        System.out.println("Car has been turned on.");
    }
}
