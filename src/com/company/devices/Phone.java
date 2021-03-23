package com.company.devices;

import com.company.Human;

import java.util.*;


public class Phone extends Device {

    String operatingSystem;
    Double screenSize;
    static final String DEFAULT_APP_SERVER = "server1.domain.x";
    static final String DEFAULT_PROTOCOL = "HTTPS";
    static final String DEFAULT_APP_VER = "1.0";
    private List<Application> applications = new ArrayList<>();


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


    public void installApplication(Application app, Human buyer){
        if (buyer.cash >= app.getPrice()){
            buyer.cash -= app.getPrice();
            applications.add(app);
            System.out.println("Application installed: " + app.toString());
        } else {
            System.out.println("'" + app.getName() + "' application installation failed. Buyer has not enough money.");
        }
    }


    public void isAppInstalled(Application appObj){

        for (Application app:applications) {
            if (app.equals(appObj)){
                System.out.println("Application '" + app.getName() + "' is installed.");
                return;
            }
        }

        System.out.println("Application is not installed.");
    }


    public void isAppInstalled(String name){

        for (Application app:applications) {
            if (app.getName().equals(name)){
                System.out.println("Application '" + app.getName() + "' is installed.");
                return;
            }
        }

        System.out.println("Application '" + name + "' is not installed.");
    }


    public void listFreeApps(){

        int appCount = 0;

        for (Application app:applications) {
            if (app.getPrice() == 0.0){
                appCount++;
                System.out.println(app.toString());
            }
        }

        System.out.println("Free apps installed: " + appCount);
    }


    public Double getAppsTotalPrice(){

        double price = 0.0;

        for (Application app:applications) {
            price += app.getPrice();
        }

        return price;
    }


    public void listAppsSortedByNameAsc(){

        System.out.println("Apps sorted by name ascending:");

        applications.sort(Comparator.comparing(Application::getName));

        for (Application app:applications)
            System.out.println(app.toString());
    }


    public void listAppsSortedByPriceAsc(){

        System.out.println("Apps sorted by price ascending:");

        applications.sort(Comparator.comparing(Application::getPrice));

        for (Application app:applications)
            System.out.println(app.toString());
    }
}
