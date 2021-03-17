package com.company.devices;

public class Electric extends Car{

    public Electric(String manufacturer, String model, String type, Integer yearOfProduction) {
        super(manufacturer, model, type, yearOfProduction);
    }


    public void refuel(){
        System.out.println("Electric car has been recharged.");
    }
}
