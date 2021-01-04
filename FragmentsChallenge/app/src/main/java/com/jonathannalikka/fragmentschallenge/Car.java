package com.jonathannalikka.fragmentschallenge;

//class to define car object, which holds all instance variables information

public class Car {

    //instance variables are for car make, model, owner, and telephone number

    private String make;
    private String model;
    private String owner;
    private String telNum;

    public Car(String make, String model, String owner, String telNum) {
        this.make = make;
        this.model = model;
        this.owner = owner;
        this.telNum = telNum;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }
}
