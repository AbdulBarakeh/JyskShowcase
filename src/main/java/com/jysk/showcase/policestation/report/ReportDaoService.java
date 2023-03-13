package com.jysk.showcase.policestation.report;

import com.jysk.showcase.policestation.vehicle.Bike;
import com.jysk.showcase.policestation.vehicle.Boat;
import com.jysk.showcase.policestation.vehicle.Car;
import com.jysk.showcase.policestation.vehicle.VehicleType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component //Set as bean/component
public class ReportDaoService {
    private static List<Report> reports = new ArrayList<>();
    private static int reportsCount = 0;
    static {
        reports.add(new Report(++reportsCount,"They Stole my car",LocalDateTime.now(),LocalDateTime.now(),new Car("GB15789","black", VehicleType.CAR,"hatchback","diesel")));
        reports.add(new Report(++reportsCount,"They Stole my boat",LocalDateTime.now(),LocalDateTime.now(),new Boat("BB56889","blue",VehicleType.BOAT,1978,2)));
        reports.add(new Report(++reportsCount,"They Stole my bike", LocalDateTime.now(),LocalDateTime.now(),new Bike("xx52-stelnummer","pink",VehicleType.BIKE,"MTB")));
    }
    public Report Save(Report report) {
        report.setId(++reportsCount);
        reports.add(report);
        return report;
    }
    public List<Report> FindAll(){
        return reports;
    }
    public Report FindOne(int id) {
        Predicate<? super Report> predicate = report -> report.getId().equals(id);
        return reports.stream().filter(predicate).findFirst().orElse(null);
    }
    public void DeleteById(int id) {
        Predicate<? super Report> predicate = report -> report.getId().equals(id);
        reports.removeIf(predicate);
    }

    public List<Report> FindByVehicleType(VehicleType type) {
        Predicate<? super Report> predicate = report -> report.getVehicle().getVehicleType().equals(type);
        return reports.stream().filter(predicate).collect(Collectors.toList());
    }
    public Report UpdateReportWithSolvedFlag(int id, boolean solved){
        reports.forEach(report -> {
            if (report.getId().equals(id)) {
                report.setSolved(solved);
                report.setSolvedTime(LocalDateTime.now());
            }
        });
        return FindOne(id);
    }
}
