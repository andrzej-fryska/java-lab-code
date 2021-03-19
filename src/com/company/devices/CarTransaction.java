package com.company.devices;

import com.company.Human;

import java.util.Date;

public class CarTransaction {

    Human seller;
    Human buyer;
    Date date;
    Double value;


    public CarTransaction(Human seller, Human buyer, Double value){
        this.seller = seller;
        this.buyer = buyer;
        this.value = value;
        this.date = new Date();
    }
}
