package com.company.devices;

import com.company.Human;
import com.company.sellable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car extends Device implements sellable{

    String type;
    public List<CarTransaction> transactions = new ArrayList<>();
    public String color;
    public Integer maxSpeed;
    public Double price;


    public Car(String manufacturer, String model, String type, Integer yearOfProduction){
        this.manufacturer = manufacturer;
        this.model = model;
        this.type = type;
        this.color = "";
        this.yearOfProduction = yearOfProduction;
        this.price = 0.0;
        this.value = 0.0;
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


    public void setValue(Double value){this.value = value;}
    public Double getValue(){return value;}

    public Integer getYear() {return yearOfProduction;}

    public void sell(Human seller, Human buyer, Double price) throws Exception {

        // check if seller has a car in a garage (if not then throw an exception)
        int sellerGaragePlaceNumber = -1;
        int index = 0;

        for(Car car: seller.garage)
            if (Objects.equals(car, this))
                sellerGaragePlaceNumber = index++;

        if (sellerGaragePlaceNumber < 0 ){
            throw new Exception("No such car in seller's garage.");
        }

        // check if buyer has a free place in a garage (if not then throw an exception)
        int buyerGaragePlaceNumber = -1;
        index = 0;
        for(Car car: buyer.garage){
            if (Objects.equals(car, null)){
                buyerGaragePlaceNumber = index;
                break;
            }
            index++;
        }

        if (buyerGaragePlaceNumber < 0 ){
            throw new Exception("No free place to put a car in buyer's garage.");
        }

        // check if buyer has enough money (if not then throws an exception)
        if (buyer.cash < price){
            throw new Exception("Buyer has not enough money.");
        }

        // check if seller is the last car's owner
        Human owner = (transactions.size() > 0) ? transactions.get(transactions.size()-1).buyer : null;
        if (!seller.equals(owner)){
            throw new Exception("The seller is not a car's owner.");
        }

        // transaction successful
        if (sellerGaragePlaceNumber >= 0 && buyerGaragePlaceNumber >= 0 && buyer.cash >= price){
            buyer.cash -= price;
            seller.cash += price;
            seller.garage[sellerGaragePlaceNumber] = null;
            buyer.garage[buyerGaragePlaceNumber] = this;
            transactions.add(new CarTransaction(seller, buyer, price));
            System.out.println("[TRANSACTION SUCCESSFUL] "
                    + seller.firstName + " sold " + this.manufacturer + " to " + buyer.firstName + " for " + price);
        }

    }


    public void listTransactions(){

        StringBuilder sb = new StringBuilder();

        int i = 1;
        for (CarTransaction ct: transactions)
        {
            String seller = (ct.seller == null) ? "-" : ct.seller.firstName + " " + ct.seller.lastName;
            String buyer = (ct.buyer == null) ? "-" : ct.buyer.firstName + " " + ct.buyer.lastName;
            Double value = (ct.value == null) ? 0.0 : ct.value;

            sb.append(i++);
            sb.append(" | seller: ").append(seller);
            sb.append(" | buyer: ").append(buyer);
            sb.append(" | value: ").append(value);
            sb.append(" | date: ").append(ct.date);
            sb.append("\n");
        }

        System.out.println(sb);
    }


    public Boolean wasOwner(Human owner){
        boolean wasOwner = false;
        for (CarTransaction ct:transactions) {
            if (ct.buyer.equals(owner)){
                wasOwner = true;
                break;
            }
        }
        return wasOwner;
    }


    public Integer getTransactionsNumber(){
        return transactions.size();
    }


    public Boolean isASoldB(Human seller, Human buyer){
        boolean isSold = false;
        for (CarTransaction ct:transactions) {
            if (ct.seller != null && ct.buyer != null) {
                if (ct.seller.equals(seller) && ct.buyer.equals(buyer)) {
                    isSold = true;
                    break;
                }
            }
        }
        return isSold;
    }

    protected void refuel(){}
}
