package com.company;

import com.company.creatures.Pet;
import com.company.devices.Car;
import com.company.devices.CarTransaction;
import com.company.devices.Phone;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Human {

    public String firstName;
    public String lastName;
    public String sex;
    public Integer age;
    private Pet pet;
    public Car[] garage;
    private Phone phone;
    private Double salary = 0.0;
    private Date previousGetSalaryDate;
    private Double previousGetSalarySalary = 0.0;
    public Double cash = 0.0;
    static public final Integer DEFAULT_GARAGE_SIZE = 2;


    public Human(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.garage = new Car[DEFAULT_GARAGE_SIZE];
    }


    public Human(String firstName, String lastName, Integer garageSize){
        this.firstName = firstName;
        this.lastName = lastName;
        this.garage = new Car[garageSize];
    }


    public String toString(){
        return firstName + " " + lastName;
    }


    Double getSalary(){
        Date now = new Date();
        System.out.println("\n[GET_SALARY " + now + "] Previous salary info retrieved at: "
                + this.previousGetSalaryDate + ", salary: " + this.previousGetSalarySalary);
        this.previousGetSalaryDate = now;
        this.previousGetSalarySalary = this.salary;
        return this.salary;
    }


    void setSalary(Double salary){
        if (salary >= 0){
            this.salary = salary;
            System.out.println("\n[SET_SALARY] Salary set to: " + this.salary);
            System.out.println("New salary value has been sent to the accounting system.");
            System.out.println("ZUS and US have been informed about a new salary. There's nothing to hide anymore.");
            System.out.println("An annex to the contract can be obtained from Ms. Hanna in HR Department.");
        } else
            System.out.println("\n[SET_SALARY] Salary not set. Lower than 0 value detected.");
    }


    public Car getCar(Integer placeNumber){

        if (placeNumber > 0 && placeNumber <= garage.length)
            return garage[placeNumber-1];

        System.out.println("Not a valid place number in this garage.");
        return null;
    }


    public void setCar(Car car, Integer placeNumber){

        if (placeNumber < 1 || placeNumber > garage.length){
            System.out.println("Not a valid place number in this garage.");
            return;
        }

        if (salary >= car.price){
            garage[placeNumber-1] = car;
            car.transactions.add(new CarTransaction(null, this, null));
            System.out.println(firstName + " " + lastName + " spent some cash to purchase a car.");
            return;
        }

        if (salary >= car.price / 12){
            garage[placeNumber-1] = car;
            car.transactions.add(new CarTransaction(null, this, null));
            System.out.println(firstName + " " + lastName + " had to take a loan to purchase a car.");
            return;
        }

        System.out.println(firstName + " " + lastName + " couldn't afford to purchase a car. Not enough money.");
    }


    public Double getCarsValueInGarage(){
        Double value = 0.0;
        for(Car car: garage)
            value += car.getValue();
        return value;
    }


    public void sortCarsInGarageByYear(){
        Arrays.sort(garage, Comparator.comparing(Car::getYear));
    }




    public Phone getPhone() { return phone; }
    public void setPhone(Phone phone){
        this.phone = phone;
    }
    public void removePhone(){
        this.phone = null;
    }


    public Pet getPet() { return pet; }
    public void setPet(Pet pet){
        this.pet = pet;
    }
    public void removePet(){
        this.pet = null;
    }
}
