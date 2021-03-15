package com.company;

public class Main {

    public static void main(String[] args) {

        Animal cat = new Animal("cat");
        cat.name = "Grumpy";
        System.out.println("ANIMAL - Species, Name: " + cat.species + ", " + cat.name);

        for (int i=1; i <= 6; i++)
            cat.feed();

        for (int i=1; i <= 12; i++)
            cat.takeForAWalk();

        cat.feed();
    }
}
