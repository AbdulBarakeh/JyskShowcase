package com.jysk.showcase.policestation.report;

import com.jysk.showcase.policestation.vehicle.VehicleType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReportController {

    private ReportDaoService service;

    public ReportController(ReportDaoService service) {
        this.service = service;
    }

    @GetMapping(path = "/reports")
    public List<Report> GetReports() {
        return service.FindAll();
    }

    @GetMapping(path = "/reports/{id}")
    public Report getReport(@PathVariable int id) {
        //Potentially make some null checking with exception being thrown.
        //At the moment the DAO returns null if it doesn't exist
        Report report = service.FindOne(id);
        return report;
    }
    @PostMapping(path = "/reports/add")
    public Report AddReport(@RequestBody Report report){
        //Should probably return a status code as well
        service.Save(report);
        return report;
    }
    @GetMapping(path = "/reports/vehicle/{type}")
    public List<Report> GetReportsByType(@PathVariable VehicleType type){
       return service.FindByVehicleType(type);
    }

    @PutMapping(path = "/reports/update/{id}/{solved}")
    public Report UpdateReportSolvedStatus(@PathVariable int id,@PathVariable boolean solved){
        return service.UpdateReportWithSolvedFlag(id,solved);
    }

}
