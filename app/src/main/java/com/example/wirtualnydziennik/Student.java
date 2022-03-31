package com.example.wirtualnydziennik;

import java.util.ArrayList;
/*
TODO
Trzeba zrobic to samo co w klasie grade
 */


public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String whichClass;
    private String email;


    ArrayList<Subject> listOfSubject = new ArrayList<>();

    public Student(String firstName, String lastName, int age, String whichClass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.whichClass = whichClass;
    }

    public void addToClass(){//przeszukiwanie przedmiotow ktore maja odopowiednie id i dodanie przedmietow dla tego ucznia
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWhichClass() {
        return whichClass;
    }

    public void setWhichClass(String whichClass) {
        this.whichClass = whichClass;
    }

}


