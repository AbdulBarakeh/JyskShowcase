package com.jysk.showcase.policestation.DAL;

import com.jysk.showcase.policestation.housing.Apartment;
import com.jysk.showcase.policestation.housing.HousingType;

import com.jysk.showcase.policestation.report.HousingReport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component //Set as bean/component
public class HousingReportDaoService {
    private static List<HousingReport> reports = new ArrayList<>();
    private static int reportsCount = 0;
    static {
        reports.add(new HousingReport(++reportsCount,"Someone burned down my apartment",LocalDateTime.now(),LocalDateTime.now(),new Apartment("Tryg A/S",2, HousingType.APARTMENT,66,2)));
        reports.add(new HousingReport(++reportsCount,"My apartment got raided by pirates",LocalDateTime.now(),LocalDateTime.now(),new Apartment("Fictitious insurance A/S",5, HousingType.APARTMENT,158,3)));
        reports.add(new HousingReport(++reportsCount,"*Something interesting*",LocalDateTime.now(),LocalDateTime.now(),new Apartment("Fictitious insurance A/S",2, HousingType.APARTMENT,1000,30)));

    }
    public HousingReport Save(HousingReport report) {
        report.setId(++reportsCount);
        reports.add(report);
        return report;
    }
    public List<HousingReport> FindAll(){
        return reports;
    }
    public HousingReport FindOne(int id) {
        Predicate<? super HousingReport> predicate = report -> report.getId().equals(id);
        return reports.stream().filter(predicate).findFirst().orElse(null);
    }
    public void DeleteById(int id) {
        Predicate<? super HousingReport> predicate = report -> report.getId().equals(id);
        reports.removeIf(predicate);
    }

    public List<HousingReport> FindByHousingType(HousingType type) {
        Predicate<? super HousingReport> predicate = report -> report.getHousing().getHousingType().equals(type);
        return reports.stream().filter(predicate).collect(Collectors.toList());
    }
    public HousingReport UpdateReportWithSolvedFlag(int id, boolean solved){
        reports.forEach(report -> {
            if (report.getId().equals(id)) {
                report.setSolved(solved);
                report.setSolvedTime(LocalDateTime.now());
            }
        });
        return FindOne(id);
    }
}
