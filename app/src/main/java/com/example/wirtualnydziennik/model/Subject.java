package com.example.wirtualnydziennik.model;

import com.example.wirtualnydziennik.Grade;

import java.util.ArrayList;

/**
 * Klasa model przedmiotu
 */
public class Subject{

     String nameOfSubject;
     String instructor;
     String whichClassId;
     ArrayList<Grade> listOfGrades = new ArrayList<>();
     Grade grade = new Grade();

    public Subject(String instructor, String nameOfSubject, String whichClassId) {
        this.instructor = instructor;
        this.nameOfSubject = nameOfSubject;
        this.whichClassId = whichClassId;
    }

    public Subject(String nameOfSubject,String instructor){
        this.nameOfSubject = nameOfSubject;
        this.instructor = instructor;
    }




    public Subject(){}



    public void addGrade(){//Widziałbym to jakie takie activity gdzie wpisujesz po koleji to edit textu a potem to pobierasz pod przycieskiem


    }

    public String getWhichClassId() {
        return whichClassId;
    }

//    public List<String> getGrades() {
//        return grades;
//    }

    public void setListOfGrades(ArrayList<Grade> listOfGrades) {
        this.listOfGrades = listOfGrades;
    }

    public String getNameOfSubject() {
        return nameOfSubject;
    }

    public void setNameOfSubject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getListOfGrades() {
        String lists = " ";
        for (Grade listOfGrade : listOfGrades) {
            lists += listOfGrade;
        }
        return lists;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "nameOfSubjec='" + nameOfSubject + '\'' +
                ", instructor='" + instructor + '\'' +
                '}';
    }

}
