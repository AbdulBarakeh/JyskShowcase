package com.jysk.showcase.policestation.vehicle;

public class Boat extends Vehicle {
    private int year;
    private int numberOfSails;


    public Boat(String registrationNumber, String color, VehicleType vehicleType, int year, int numberOfSails) {
        super(registrationNumber, color, vehicleType);
        setYear(year);
        setNumberOfSails(numberOfSails);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfSails() {
        return numberOfSails;
    }

    public void setNumberOfSails(int numberOfSails) {
        this.numberOfSails = numberOfSails;
    }
}
