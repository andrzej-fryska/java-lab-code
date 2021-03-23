package com.company;

import com.company.creatures.FarmAnimal;
import com.company.creatures.Pet;
import com.company.devices.*;

import java.util.ArrayList;
import java.util.List;

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

        Human human = new Human("Jack", "Trades");
        human.sex = "male";
        human.age = 20;
        System.out.println(human.toString());

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

        Human person = new Human("Jack", "Many");
        person.setSalary(2000.0);

        person.setCar(car, 1);
        person.setSalary(10000.0);
        person.setCar(car, 1);
        person.setSalary(65000.0);
        person.setCar(car,1);


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

        Human seller = new Human("Jack", "The Seller");
        seller.cash = 0.0;

        Human buyer = new Human("Joe", "The Buyer");
        buyer.cash = 0.0;

        tiger.sell(seller, buyer, 1000.0);
        seller.setPet(tiger);
        tiger.sell(seller, buyer, 1000.0);
        buyer.cash = 1500.0;
        System.out.println("Seller's pet: " + seller.getPet() + " | Buyer's pet: " + buyer.getPet());
        tiger.sell(seller, buyer, 1000.0);
        System.out.println("Seller's pet: " + seller.getPet() + " | Buyer's pet: " + buyer.getPet());

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


        // Task 10 test

        title("10");

        Phone smartphone = new Phone("Apple","Model X", "iOS", 2020);
        smartphone.installAnApp("Signal");
        smartphone.installAnApp("Telegram", "1.0");
        smartphone.installAnApp("Whats Up", "1.0", "server3.domain.x");

        List<String> appList = new ArrayList<>();
        appList.add("Signal");
        appList.add("Telegram");
        appList.add("Whats Up");
        smartphone.installAnApp(appList);

        Url url = new Url("Signal", "2.0", "server5.domain.x");
        smartphone.installAnApp(url);

        System.out.println();

        Diesel card = new Diesel("VW", "Passat", "sedan", 2010);
        Electric care = new Electric("Toyota", "Prius", "sedan", 2015);
        Lpg carl = new Lpg("Audi", "80", "sedan", 2005);
        card.refuel();
        care.refuel();
        carl.refuel();


        // Task 11 test

        title("11");

        System.out.println("Seller's money: " + seller.cash + " | Buyer's money: " + buyer.cash);
        Car skoda = new Car("Skoda", "110 R", "coupe", 1979);

        // no such car in seller's garage exception
        try { skoda.sell(seller, buyer, 500.0); } catch (Exception e) { e.printStackTrace(); }
        seller.setCar(skoda, 1);

        // no place to put a car in buyer's garage exception
        buyer.setCar(skoda, 1);
        buyer.setCar(skoda, 2);
        try { skoda.sell(seller, buyer, 500.0); } catch (Exception e) { e.printStackTrace(); }

        // buyer has not enough money exception
        buyer.garage[0] = buyer.garage[1] = null;
        try { skoda.sell(seller, buyer, 500.0); } catch (Exception e) { e.printStackTrace(); }

        // the seller is not a cars owner exception
        buyer.cash = 1000.0;
        try { skoda.sell(seller, buyer, 500.0); } catch (Exception e) { e.printStackTrace(); }

        // get total value of cars in a garage
        Human smith = new Human("George", "Smith");
        Car audi = new Car("Audi", "Quattro", "sedan", 2019);
        Car vw = new Car("VW", "Passat", "sedan", 2010);
        audi.setValue(1500.0);
        vw.setValue(500.0);
        smith.setCar(audi, 1);
        smith.setCar(vw, 2);
        System.out.println("Total value of cars in " + smith.firstName + "'s garage: " + smith.getCarsValueInGarage());

        // sort cars in garage by year of production ascending
        System.out.println("[garage before sorting]");
        for (Car c: smith.garage)
            System.out.println(c.toString());
        smith.sortCarsInGarageByYear();
        System.out.println("[garage after sorting]");
        for (Car c: smith.garage)
            System.out.println(c.toString());


        // Task 12 test

        title("12");

        Human joe = new Human("Joe", "Seller");
        Human jack = new Human("Jack", "Buyer");
        Car toyota = new Car("Toyota", "Prius", "sedan", 2015);

        joe.setCar(toyota, 1);
        toyota.listTransactions();

        System.out.println("Jack was toyota's owner: " + toyota.wasOwner(jack));
        System.out.println("Is Joe sold toyota to Jack? : " + toyota.isASoldB(joe, jack));
        jack.cash = 500.0;

        try { toyota.sell(joe, jack, 100.0); } catch (Exception e) { e.printStackTrace(); }
        toyota.listTransactions();
        System.out.println("Jack was toyota's owner: " + toyota.wasOwner(jack));
        System.out.println("Is Joe sold toyota to Jack? : " + toyota.isASoldB(joe, jack));

        System.out.println("Total number of transactions related to toyota: " + toyota.getTransactionsNumber());


        // Task 13 test

        title("13");

        Application signal = new Application("Signal", "1.1", 0.0);
        Application telegram = new Application("Telegram", "3.5", 0.0);
        Application skype = new Application("Skype", "11", 0.0);
        Application skypeCommercial = new Application("Skype For Business", "11", 100.0);
        Application whatsup = new Application("WhatsUp", "4.2", 0.0);
        Application whatsupCommercial = new Application("WhatsUp For Groups", "4.2", 50.0);
        Application photoshop = new Application("Photoshop", "CS6", 1000.0);

        Human collector = new Human("Jack", "The Collector");
        Phone newPhone = new Phone("Apple", "newPhone", "iOS", 2021);

        newPhone.installApplication(signal, collector);
        newPhone.installApplication(telegram, collector);
        newPhone.installApplication(whatsup, collector);
        newPhone.installApplication(skype, collector);

        newPhone.installApplication(photoshop, collector);
        collector.cash = 200.0;
        System.out.println("Buyers cash: " + collector.cash);
        newPhone.installApplication(whatsupCommercial, collector);
        newPhone.installApplication(skypeCommercial, collector);
        System.out.println("Buyers cash: " + collector.cash);

        newPhone.isAppInstalled(signal);
        newPhone.isAppInstalled("Signal");
        newPhone.isAppInstalled("Photoshop");
        System.out.println();
        newPhone.listFreeApps();
        System.out.println();
        System.out.println("Total price of apps on phone: " + newPhone.getAppsTotalPrice());

        System.out.println();
        newPhone.listAppsSortedByNameAsc();
        System.out.println();
        newPhone.listAppsSortedByPriceAsc();
    }


    private static void title(String num){
        System.out.println("\n----- TASK " + num + " TEST\n");
    }
}
