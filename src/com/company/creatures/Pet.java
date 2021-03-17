package com.company.creatures;

public class Pet extends Animal{

    public Pet(String species) {
        super(species);
    }


    @Override
    public void feed() {
        System.out.println("[feed] Yummy.");
    }

    @Override
    public void feed(Double foodWeight) {
        System.out.println("[feed] Yummy weight of food: " + foodWeight);
    }

}
