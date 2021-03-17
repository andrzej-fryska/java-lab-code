package com.company.creatures;

public class FarmAnimal extends Animal implements edible{

    public FarmAnimal(String species) {
        super(species);
    }

    @Override
    public void beEaten() {
        System.out.println("[beEaten] I am consumed.");
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
