package com.jysk.showcase.policestation.vehicle;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@JsonTypeInfo(
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "vehicleType",
        use = JsonTypeInfo.Id.NAME,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "CAR"),
        @JsonSubTypes.Type(value = Boat.class, name = "BOAT"),
        @JsonSubTypes.Type(value = Bike.class, name = "BIKE")
})
@Component
public abstract class Vehicle {
    @Autowired
    private String RegistrationNumber;
    @Autowired
    private String Color;
    @Autowired
    private VehicleType VehicleType;

    public Vehicle(String registrationNumber, String color, VehicleType vehicleType) {
        setRegistrationNumber(registrationNumber);
        setColor(color);
        setVehicleType(vehicleType);
    }



    public VehicleType getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.VehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return RegistrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        RegistrationNumber = registrationNumber;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
