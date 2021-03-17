package com.company;

import java.io.File;

public class Animal implements sellable{

    final String species;
    String name;
    private Double weight;
    private Double currentWeight;
    static public final Double DEFAULT_ANIMAL_WEIGHT = 1.0;
    File pic;


    Animal(String species){
        this.species = species;

        switch(this.species){
            case "dog":
                this.weight = 20.0;
                break;
            case "cat":
                this.weight = 5.0;
                break;
            case "cow":
                this.weight = 400.0;
                break;
            default:
                this.weight = DEFAULT_ANIMAL_WEIGHT;
        }

        this.currentWeight = this.weight;
    }


    public String toString(){
        return species + " " + name + " " + weight;
    }


    void feed(){
        if (this.currentWeight > 0) {
            this.currentWeight += 1;
            if(this.currentWeight > this.weight * 2)
                System.out.print("Why do you try to fatten me up?");
            else
                System.out.print("Yummy!");
            System.out.println(" My current weight is: " + this.currentWeight);
        } else {
            System.out.println("No food for the dead " + this.species + ".");
        }
    }


    void takeForAWalk() {
        if (this.currentWeight > 0) {
            this.currentWeight -= 1;
            if(this.currentWeight < this.weight / 2)
                System.out.print("Why do you try to starve me?");
            else
                System.out.print("Thanks for a walk.");
            System.out.println(" My current weight is: " + this.currentWeight);
        } else {
            System.out.println("This " + this.species + " is in permanent coma.");
        }
    }


    public void sell(Human seller, Human buyer, Double price){

        if (seller.pet == null){
            System.out.println("Transaction denied. Seller has no any pets.");
            return;
        }

        if (buyer.cash < price){
            System.out.println("Transaction denied. Buyer has not enough money.");
            return;
        }

        buyer.cash -= price;
        seller.cash += price;
        buyer.pet = seller.pet;
        seller.pet = null;
        System.out.println("Transaction successful. "
                + buyer.firstName + " bought " + this.species + " from " + seller.firstName + " for " + price);
    }
}
