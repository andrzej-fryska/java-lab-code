package com.company;

import com.company.creatures.FarmAnimal;
import com.company.creatures.Pet;
import com.company.devices.Car;
import com.company.devices.Phone;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Task 1 test

        title("1");

        Pet cat = new Pet("cat");
        cat.name = "Grumpy";
        System.out.println("ANIMAL - Species, Name: " + cat.species + ", " + cat.name);

        for (int i=1; i <= 6; i++)
            cat.feed();

        for (int i=1; i <= 12; i++)
            cat.takeForAWalk();

        cat.feed();


        // Task 2 test

        title("2");

        Human human = new Human();
        human.firstName = "Jack";
        human.lastName = "Trades";
        human.sex = "male";
        human.age = 20;
        System.out.println("HUMAN - First Name, Last Name, Sex, Age: "
                + human.firstName + ", " + human.lastName + ", " + human.sex + ", " + human.age);

        Car automobile = new Car("BMW", "3 series", "coupe", 2020);
        automobile.color = "red";
        automobile.maxSpeed = 240;
        automobile.price = 40000.0;

        System.out.println("CAR: " + automobile.toString());


        // Task 3 & 4 test

        title("3 & 4");

        System.out.println("Current salary: " + human.getSalary());
        human.setSalary(1000.0);

        Thread.sleep(1000); // for testing timestamps of getSalary method
        System.out.println("Current salary: " + human.getSalary());

        human.setSalary(2000.0);

        Thread.sleep(1000); // for testing timestamps of getSalary method
        System.out.println("Current salary: " + human.getSalary());

        human.setSalary(-2000.0);


        // Task 5 test

        title("5");

        Car car = new Car("Audi", "Quattro", "sedan", 2019);
        car.price = 60000.0;

        Human person = new Human();
        person.firstName = "Jack";
        person.setSalary(2000.0);

        person.setCar(car);
        person.setSalary(10000.0);
        person.setCar(car);
        person.setSalary(65000.0);
        person.setCar(car);


        // Task 6 test

        title("6");

        Car car1 = new Car("VW", "Passat", "sedan", 2018);
        Car car2 = new Car("VW", "Passat", "sedan", 2018);

        System.out.println("Car1 equals Car2: " + car1.equals(car2));
        System.out.println("Car1: " + car1);
        System.out.println("Car2: " + car2);

        System.out.println();
        System.out.println(cat.toString());
        System.out.println(automobile.toString());
        System.out.println(human.toString());

        Phone phone = new Phone("Apple", "iPhone", "iOS", 2020);
        System.out.println(phone.toString());


        // Task 7 test

        title("7");

        System.out.println(car1.toString());
        car1.turnOn();
        System.out.println(phone.toString());
        phone.turnOn();


        // Task 8 test

        title("8");

        Pet tiger = new Pet("tiger");
        tiger.name = "Mr. King";

        Human seller = new Human();
        seller.firstName = "Jack The Seller";
        seller.cash = 0.0;

        Human buyer = new Human();
        buyer.firstName = "Joe The Buyer";
        buyer.cash = 0.0;

        tiger.sell(seller, buyer, 1000.0);
        seller.setPet(tiger);
        tiger.sell(seller, buyer, 1000.0);
        buyer.cash = 1500.0;
        System.out.println("Seller's pet: " + seller.getPet() + " | Buyer's pet: " + buyer.getPet());
        tiger.sell(seller, buyer, 1000.0);
        System.out.println("Seller's pet: " + seller.getPet() + " | Buyer's pet: " + buyer.getPet());

        System.out.println();

        System.out.println("Seller's money: " + seller.cash + " | Buyer's money: " + buyer.cash);
        Car skoda = new Car("Skoda", "110 R", "coupe", 1979);
        skoda.sell(seller, buyer, 500.0);
        seller.assignCar(skoda);
        skoda.sell(seller, buyer, 500.0);
        System.out.println("Seller's money: " + seller.cash + " | Buyer's money: " + buyer.cash);

        System.out.println();

        Phone iphone = new Phone("Apple", "iPhone 4S", "iOS", 2010);
        iphone.sell(seller, buyer, 50.0);
        seller.setPhone(iphone);
        iphone.sell(seller, buyer, 50.0);
        buyer.cash = 100.0;
        iphone.sell(seller, buyer, 50.0);


        // Task 9 test

        title("9");

        FarmAnimal cow = new FarmAnimal("cow");
        System.out.println(cow.toString());
        cow.beEaten();
        cow.feed();
        cow.feed(10.0);

        Pet familiar = new Pet("cat");
        familiar.name = "Garfield";
        System.out.println(familiar.toString());
        familiar.feed();
        familiar.feed(5.0);

    }


    private static void title(String num){
        System.out.println("\n----- TASK " + num + " TEST\n");
    }
}
