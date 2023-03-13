package com.jysk.showcase.policestation.housing;

public class Apartment extends Housing{

    private Integer SquareFootage;
    private Integer NumberOfBathrooms;


    public Apartment(String insurance, Integer numberOfResidents, com.jysk.showcase.policestation.housing.HousingType housingType, Integer squareFootage, Integer numberOfBathrooms) {
        super(insurance, numberOfResidents, housingType);
        setSquareFootage(squareFootage);
        setNumberOfBathrooms(numberOfBathrooms);
    }

    public Integer getSquareFootage() {
        return SquareFootage;
    }

    public void setSquareFootage(Integer squareFootage) {
        SquareFootage = squareFootage;
    }

    public Integer getNumberOfBathrooms() {
        return NumberOfBathrooms;
    }

    public void setNumberOfBathrooms(Integer numberOfBathrooms) {
        NumberOfBathrooms = numberOfBathrooms;
    }
}
