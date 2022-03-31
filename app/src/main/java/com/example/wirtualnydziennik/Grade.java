package com.example.wirtualnydziennik;

public class Grade {
    private float value;
    private int weight;
    private String description;

    public Grade(float value, int weight, String description) {
        this.value = value;
        this.weight = weight;
        this.description = description;
    }

    public Grade(){

    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
