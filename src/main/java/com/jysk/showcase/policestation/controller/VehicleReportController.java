package com.jysk.showcase.policestation.controller;

import com.jysk.showcase.policestation.report.VehicleReport;
import com.jysk.showcase.policestation.DAL.VehicleReportDaoService;
import com.jysk.showcase.policestation.vehicle.VehicleType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleReportController {

    private VehicleReportDaoService service;

    public VehicleReportController(VehicleReportDaoService service) {
        this.service = service;
    }

    @GetMapping(path = "/reports/vehicle/")
    public List<VehicleReport> GetVehicleReports() {
        return service.FindAll();
    }

    @GetMapping(path = "/reports/vehicle/id/{id}")
    public VehicleReport GetVehicleReport(@PathVariable int id) {
        //Potentially make some null checking with exception being thrown.
        //At the moment the DAO returns null if it doesn't exist
        VehicleReport report = service.FindOne(id);
        return report;
    }
    @PostMapping(path = "/reports/vehicle/add")
    public VehicleReport AddVehicleReport(@RequestBody VehicleReport report){
        //Should probably return a status code as well
        service.Save(report);
        return report;
    }
    @GetMapping(path = "/reports/vehicle/type/{type}")
    public List<VehicleReport> GetReportsByVehicleType(@PathVariable VehicleType type){
       return service.FindByVehicleType(type);
    }

    @PutMapping(path = "/reports/vehicle/update/{id}/{solved}")
    public VehicleReport UpdateReportSolvedStatus(@PathVariable int id, @PathVariable boolean solved){
        return service.UpdateReportWithSolvedFlag(id,solved);
    }

}
