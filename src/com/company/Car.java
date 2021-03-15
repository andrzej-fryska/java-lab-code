package com.company;

public class Car {

    final String manufacturer;
    final String model;
    final String type;
    public String color;
    public Integer maxSpeed;
    public Double price;


    Car(String manufacturer, String model, String type){
        this.manufacturer = manufacturer;
        this.model = model;
        this.type = type;
    }
}
