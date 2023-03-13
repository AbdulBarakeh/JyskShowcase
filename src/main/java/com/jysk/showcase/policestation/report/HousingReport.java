package com.jysk.showcase.policestation.report;

import com.jysk.showcase.policestation.housing.Housing;

import java.time.LocalDateTime;

public class HousingReport extends Report{

    private com.jysk.showcase.policestation.housing.Housing Housing;
    public HousingReport(Integer id, String description, LocalDateTime createTime, LocalDateTime updateTime, Housing housing) {
        super(id, description, createTime, updateTime);
        setHousing(housing);
    }

    public com.jysk.showcase.policestation.housing.Housing getHousing() {
        return Housing;
    }

    public void setHousing(com.jysk.showcase.policestation.housing.Housing housing) {
        Housing = housing;
    }
}
