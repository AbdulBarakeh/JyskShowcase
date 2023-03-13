package com.jysk.showcase.policestation.vehicle;

public class Car extends Vehicle {
    private String type; //Sedan, Hatchback, SUV
    private String fuelType; //Diesel, Petrol



    public Car(String registrationNumber, String color, VehicleType vehicleType, String type, String fuelType) {
        super(registrationNumber, color, vehicleType);
        setType(type);
        setFuelType(fuelType);
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
