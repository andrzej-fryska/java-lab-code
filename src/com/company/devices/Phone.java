package com.company.devices;

public class Phone {
    String manufacturer;
    String model;
    String operatingSystem;
    Double screenSize;


    public Phone(String manufacturer, String model, String operatingSystem){
        this.manufacturer = manufacturer;
        this.model = model;
        this.operatingSystem = operatingSystem;
    }


    public String toString(){
        return manufacturer + " " + model + " " + operatingSystem;
    }

}
