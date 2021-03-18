package com.company.devices;

abstract class Device {

    String manufacturer;
    String model;
    Integer yearOfProduction;
    Double value;

    abstract void turnOn();
}
