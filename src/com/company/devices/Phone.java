package com.company.devices;

import com.company.Human;

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


    public void sell(Human seller, Human buyer, Double price){

        if (seller.getPhone() == null){
            System.out.println("Transaction denied. Seller has no any phones.");
            return;
        }

        if (buyer.cash < price){
            System.out.println("Transaction denied. Buyer has not enough money.");
            return;
        }

        buyer.cash -= price;
        seller.cash += price;
        buyer.setPhone(seller.getPhone());
        seller.removePhone();
        System.out.println("Transaction successful. "
                + buyer.firstName + " bought " + this.toString() + " from " + seller.firstName + " for " + price);
    }

}
