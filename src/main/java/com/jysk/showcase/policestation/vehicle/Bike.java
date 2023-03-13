package com.jysk.showcase.policestation.vehicle;


public class Bike extends Vehicle {
    private String type; // MTB,BMX,E-Bike

    public Bike(String registrationNumber, String color, VehicleType vehicleType, String type) {
        super(registrationNumber, color, vehicleType);
        setType(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
