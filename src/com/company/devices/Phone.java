package com.company.devices;

import com.company.Human;
import java.util.List;


public class Phone extends Device {

    String operatingSystem;
    Double screenSize;
    static final String DEFAULT_APP_SERVER = "server1.domain.x";
    static final String DEFAULT_PROTOCOL = "HTTPS";
    static final String DEFAULT_APP_VER = "1.0";


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


    public void installAnApp(String appName){
        System.out.println("[INSTALL_APP] (name) " + appName);
    }


    public void installAnApp(String appName, String appVer){
        System.out.println("[INSTALL_APP] (name ver) " + appName + " " + appVer);
    }


    public void installAnApp(String appName, String appVer, String appServer){
        System.out.println("[INSTALL_APP] (name ver server) " + appName + " " + appVer + " " + appServer);
    }


    public void installAnApp(List<String> appList){
        System.out.print("[INSTALL_APP] (list) ");
        for(String appName:appList)
            System.out.print(appName + " ");
        System.out.println();
    }


    public void installAnApp(Url url){
        System.out.println("[INSTALL_APP] (url object) " + url.appName + " " + url.appVer + " " + url.appServer);
    }

}
