package com.company.devices;

public class Lpg extends Car{

    public Lpg(String manufacturer, String model, String type, Integer yearOfProduction) {
        super(manufacturer, model, type, yearOfProduction);
    }


    public void refuel(){
        System.out.println("LPG car has been refueled.");
    }

}
