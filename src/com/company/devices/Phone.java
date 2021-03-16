package com.company.devices;

public class Phone extends Device {

    String operatingSystem;
    Double screenSize;


    public Phone(String manufacturer, String model, String operatingSystem, Integer yearOfProduction){
        this.manufacturer = manufacturer;
        this.model = model;
        this.operatingSystem = operatingSystem;
        this.yearOfProduction = yearOfProduction;
    }


    public String toString(){
        return manufacturer + " " + model + " " + operatingSystem + " " + yearOfProduction;
    }


    public void turnOn(){
        System.out.println("Phone has been turned on.");
    }
}
