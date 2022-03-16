package com.example.wirtualnydziennik;

public class User {
    private String email;
    private String password;
    private String fullName;
    private String location;
    private String phoneNumber;
    private boolean isProfessor;
    public User() {
    }
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, String fullName, String location, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

    public User(String email, String password, String fullName, String location, String phoneNumber, boolean isProfessor) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.isProfessor = isProfessor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isProfessor() {
        return isProfessor;
    }

    public void setProfessor(boolean professor) {
        isProfessor = professor;
    }
}
