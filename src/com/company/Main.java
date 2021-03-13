package com.company;

public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.species = "dog";
        animal.name = "Lassie";
        animal.weight = 20.0;
        System.out.println("ANIMAL - Species, Name, Weight: "
                + animal.species + ", " + animal.name + ", " + animal.weight);

        Human human = new Human();
        human.firstName = "Jack";
        human.lastName = "Trades";
        human.sex = "male";
        human.age = 20;
        System.out.println("HUMAN - First Name, Last Name, Sex, Age: "
                + human.firstName + ", " + human.lastName + ", " + human.sex + ", " + human.age);

        Phone phone = new Phone();
        phone.manufacturer = "Apple";
        phone.model = "iPhone";
        phone.operatingSystem = "iOS";
        phone.screenSize = 5.5;
        System.out.println("PHONE - Manufacturer, Model, OS, Screen size: "
                + phone.manufacturer + ", " + phone.model + ", " + phone.operatingSystem + ", " + phone.screenSize);

    }
}
