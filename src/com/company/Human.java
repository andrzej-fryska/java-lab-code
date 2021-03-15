package com.company;

import java.util.Date;

public class Human {

    String firstName;
    String lastName;
    String sex;
    Integer age;
    Animal pet;
    Car car;
    private Double salary = 0.0;
    private Date previousGetSalaryDate;
    private Double previousGetSalarySalary = 0.0;


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
}
