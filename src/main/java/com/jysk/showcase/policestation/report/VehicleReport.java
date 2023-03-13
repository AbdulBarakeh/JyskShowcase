package com.jysk.showcase.policestation.report;
import com.jysk.showcase.policestation.vehicle.Vehicle;

import java.time.LocalDateTime;

public class VehicleReport extends Report {

    private com.jysk.showcase.policestation.vehicle.Vehicle Vehicle;

    public VehicleReport(Integer id, String description, LocalDateTime createTime, LocalDateTime updateTime, com.jysk.showcase.policestation.vehicle.Vehicle vehicle) {
        super(id, description, createTime, updateTime);
        setVehicle(vehicle);
    }

    public Vehicle getVehicle() {
        return Vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        Vehicle = vehicle;
    }

}
