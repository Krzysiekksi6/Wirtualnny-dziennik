package com.example.wirtualnydziennik;

public class User {
    private String email;
    private String password;
    private String firstName;
    private String location;
    private String phoneNumber;
    private boolean isProfessor;
    private String lastName;
    private String id;

    public User() { }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, String fullName, String location, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.firstName = fullName;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

    public User(String email, String password, String fullName, String lastName, String location, String phoneNumber, boolean isProfessor) {
        this.email = email;
        this.password = password;
        this.firstName = fullName;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.isProfessor = isProfessor;
        this.lastName = lastName;
    }

    public User(String email, String firstName, String id, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
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
        return firstName;
    }

    public void setFullName(String fullName) {
        this.firstName = fullName;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
