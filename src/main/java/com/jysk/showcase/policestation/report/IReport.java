package com.jysk.showcase.policestation.report;

import java.time.LocalDateTime;

public interface IReport {
    Integer Id = null;
    String Description = null;
    LocalDateTime CreateTime = null;
    LocalDateTime UpdateTime = null;
    Boolean Solved = null;
    LocalDateTime SolvedTime = null;
}
