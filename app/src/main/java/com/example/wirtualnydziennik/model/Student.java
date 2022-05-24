package com.example.wirtualnydziennik.model;

import java.util.ArrayList;

/**
 * Klasa model studenta
 */

public class Student {
    private String firstName;
    private String lastName;
    private String birthDate;
    private int age;
    private String whichClass;
    private String email;


    ArrayList<Subject> listOfSubject = new ArrayList<>();


    public Student(String firstName, String lastName, String birthDate, String whichClass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.whichClass = whichClass;
        attachSubjectList();
    }

    public void addToClass(){//przeszukiwanie przedmiotow ktore maja odopowiednie id i dodanie przedmietow dla tego ucznia
    }

    public void attachSubjectList(){
        switch (whichClass){
            case " 1  A ":
                listOfSubject.add(new Subject("Fizyka","Marek"));
                listOfSubject.add(new Subject("Matematyka","Kaziu"));
                break;
            case " 2  A ":
                listOfSubject.add(new Subject("Geografia","Ziutek"));
                listOfSubject.add(new Subject("Chemia","Kuba"));
                break;
            default:


        }

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

    public String getBirthDate() {
        return birthDate;
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


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", whichClass='" + whichClass + '\'' +
                '}' + listOfSubject.toString();
    }

}


