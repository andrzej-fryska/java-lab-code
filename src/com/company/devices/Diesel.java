package com.company.devices;

public class Diesel extends Car{

    public Diesel(String manufacturer, String model, String type, Integer yearOfProduction) {
        super(manufacturer, model, type, yearOfProduction);
    }


    public void refuel(){
        System.out.println("Diesel car has been refueled.");
    }
}
