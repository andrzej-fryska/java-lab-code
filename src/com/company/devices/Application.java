package com.company.devices;

public class Application {

    private String name;
    private String ver;
    private Double price;

    public Application(String name, String ver, Double price){
        this.name = name;
        this.ver = ver;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + ver + " " + price;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() { return name; }
}
