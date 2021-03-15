package com.company;

public class Main {

    public static void main(String[] args) {

        // Task 0 testing

        Animal cat = new Animal("cat");
        cat.name = "Grumpy";
        System.out.println("ANIMAL - Species, Name: " + cat.species + ", " + cat.name);

        for (int i=1; i <= 6; i++)
            cat.feed();

        for (int i=1; i <= 12; i++)
            cat.takeForAWalk();

        cat.feed();


        // Task 1 testing

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
        automobile.price = 40000;

        human.car = automobile;
        System.out.println(human.firstName + " owns " + human.car.manufacturer);
    }
}
