package com.jysk.showcase.policestation.controller;

import com.jysk.showcase.policestation.housing.HousingType;
import com.jysk.showcase.policestation.report.HousingReport;
import com.jysk.showcase.policestation.DAL.HousingReportDaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HousingReportController {

    private HousingReportDaoService service;

    public HousingReportController(HousingReportDaoService service) {
        this.service = service;
    }

    @GetMapping(path = "/reports/housing")
    public List<HousingReport> GetReports() {
        return service.FindAll();
    }

    @GetMapping(path = "/reports/housing/{id}")
    public HousingReport GetReport(@PathVariable int id) {
        //Potentially make some null checking with exception being thrown.
        //At the moment the DAO returns null if it doesn't exist
        HousingReport report = service.FindOne(id);
        return report;
    }
    @PostMapping(path = "/reports/housing/add")
    public HousingReport AddReport(@RequestBody HousingReport report){
        //Should probably return a status code as well
        service.Save(report);
        return report;
    }
    @GetMapping(path = "/reports/housing/{type}")
    public List<HousingReport> GetReportsByType(@PathVariable HousingType type){
       return service.FindByHousingType(type);
    }

    @PutMapping(path = "/reports/housing/update/{id}/{solved}")
    public HousingReport UpdateReportSolvedStatus(@PathVariable int id, @PathVariable boolean solved){
        return service.UpdateReportWithSolvedFlag(id,solved);
    }

}
