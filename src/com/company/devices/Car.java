package com.company.devices;

public class Car {

    final String manufacturer;
    final String model;
    final String type;
    public String color;
    public Integer maxSpeed;
    public Double price;


    public Car(String manufacturer, String model, String type){
        this.manufacturer = manufacturer;
        this.model = model;
        this.type = type;
        this.color = "-";
    }


    public String toString(){
        return manufacturer + " " + model + " " + type;
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Car car = (Car) obj;
        return this.manufacturer.equals(car.manufacturer) && this.model.equals(car.model) && this.type.equals(car.type)
                && this.color.equals(car.color) && this.maxSpeed == car.maxSpeed && this.price == car.price;
    }
}
