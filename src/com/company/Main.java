package com.company;

import com.company.devices.Car;
import com.company.devices.Phone;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Task 1 test

        Animal cat = new Animal("cat");
        cat.name = "Grumpy";
        System.out.println("ANIMAL - Species, Name: " + cat.species + ", " + cat.name);

        for (int i=1; i <= 6; i++)
            cat.feed();

        for (int i=1; i <= 12; i++)
            cat.takeForAWalk();

        cat.feed();


        // Task 2 test

        Human human = new Human();
        human.firstName = "Jack";
        human.lastName = "Trades";
        human.sex = "male";
        human.age = 20;
        System.out.println("HUMAN - First Name, Last Name, Sex, Age: "
                + human.firstName + ", " + human.lastName + ", " + human.sex + ", " + human.age);

        Car automobile = new Car("BMW", "3 series", "coupe");
        automobile.color = "red";
        automobile.maxSpeed = 240;
        automobile.price = 40000.0;

        System.out.println("CAR: " + automobile.toString());


        // Task 3 & 4 test

        System.out.println("Current salary: " + human.getSalary());
        human.setSalary(1000.0);

        Thread.sleep(1000); // for testing timestamps of getSalary method
        System.out.println("Current salary: " + human.getSalary());

        human.setSalary(2000.0);

        Thread.sleep(1000); // for testing timestamps of getSalary method
        System.out.println("Current salary: " + human.getSalary());

        human.setSalary(-2000.0);


        // Task 5 test

        Car car = new Car("Audi", "Quattro", "sedan");
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

        Car car1 = new Car("VW", "Passat", "sedan");
        Car car2 = new Car("VW", "Passat", "sedan");

        System.out.println("\nCar1 equals Car2: " + car1.equals(car2));
        System.out.println("Car1: " + car1);
        System.out.println("Car2: " + car2);

        System.out.println();
        System.out.println(cat.toString());
        System.out.println(automobile.toString());
        System.out.println(human.toString());

        Phone phone = new Phone("Apple", "iPhone", "iOS");
        System.out.println(phone.toString());
    }
}
