package com.company;

import com.company.devices.Car;
import com.company.devices.Phone;

import java.util.Date;

public class Human {

    public String firstName;
    String lastName;
    String sex;
    Integer age;
    Animal pet;
    private Car car;
    private Phone phone;
    private Double salary = 0.0;
    private Date previousGetSalaryDate;
    private Double previousGetSalarySalary = 0.0;
    public Double cash = 0.0;


    public String toString(){
        return firstName + " " + lastName + " " + sex + " " + age;
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


    public Car getCar(){
        return this.car;
    }


    public void setCar(Car car){

        if (this.salary > car.price){
            this.car = car;
            System.out.println("\n" + this.firstName + " spent some cash to purchase a car.");
            return;
        }

        if (this.salary > car.price / 12){
            this.car = car;
            System.out.println("\n" + this.firstName + " had to take a loan to purchase a car.");
            return;
        }

        System.out.println("\n" + this.firstName + " couldn't afford to purchase a car. Not enough money.");
    }


    public void assignCar(Car car){
        this.car = car;
    }


    public void removeCar(){
        this.car = null;
    }


    public Phone getPhone() {
        return phone;
    }


    public void setPhone(Phone phone){
        this.phone = phone;
    }


    public void removePhone(){
        this.phone = null;
    }
}
