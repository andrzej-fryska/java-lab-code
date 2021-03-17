package com.company.devices;

import com.company.Human;
import com.company.sellable;

public class Car extends Device implements sellable{

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


    public void sell(Human seller, Human buyer, Double price){

        if (seller.getCar() == null){
            System.out.println("Transaction denied. Seller has no any cars.");
            return;
        }

        if (buyer.cash < price){
            System.out.println("Transaction denied. Buyer has not enough money.");
            return;
        }

        buyer.cash -= price;
        seller.cash += price;
        buyer.assignCar(seller.getCar());
        seller.removeCar();
        System.out.println("Transaction successful. "
                + buyer.firstName + " bought " + this.toString() + " from " + seller.firstName + " for " + price);
    }

}
