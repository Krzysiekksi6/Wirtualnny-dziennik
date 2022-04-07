package com.example.wirtualnydziennik;

import android.view.accessibility.AccessibilityRecord;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/* TODO
*  zrobić addGrade myśle czy trzeba robic musi byc to w klasie sterującej  */




public class Subject{

    private String nameOfSubjec;
    private String instructor;
    private String whichClasId;
    ArrayList<Grade> listOfGrades = new ArrayList<>();
    Grade grade = new Grade();

    public Subject(String nameOfSubjec, String instructor, String whichClasId) {
        this.nameOfSubjec = nameOfSubjec;
        this.instructor = instructor;
        this.whichClasId = whichClasId;
    }

    public Subject(String nameOfSubjec,String instructor){
        this.nameOfSubjec = nameOfSubjec;
        this.instructor = instructor;
    }



    public void addGrade(){//Widziałbym to jakie takie activity gdzie wpisujesz po koleji to edit textu a potem to pobierasz pod przycieskiem


    }


    public String getNameOfSubjec() {
        return nameOfSubjec;
    }

    public void setNameOfSubjec(String nameOfSubjec) {
        this.nameOfSubjec = nameOfSubjec;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "nameOfSubjec='" + nameOfSubjec + '\'' +
                ", instructor='" + instructor + '\'' +
                '}';
    }

}
