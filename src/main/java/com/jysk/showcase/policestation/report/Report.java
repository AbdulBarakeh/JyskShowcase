package com.jysk.showcase.policestation.report;

import java.time.LocalDateTime;

public abstract class Report {
    private Integer Id;
    private String Description;
    private LocalDateTime CreateTime;
    private LocalDateTime UpdateTime;
    private Boolean Solved;
    private LocalDateTime SolvedTime;

    public Report(Integer id, String description, LocalDateTime createTime, LocalDateTime updateTime) {
        setId(id);
        setDescription(description);
        setCreateTime(createTime);
        setUpdateTime(updateTime);
    }

    public LocalDateTime getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        UpdateTime = updateTime;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalDateTime getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        CreateTime = createTime;
    }

    public Boolean getSolved() {
        return Solved;
    }

    public void setSolved(Boolean solved) {
        Solved = solved;
    }

    public LocalDateTime getSolvedTime() {
        return SolvedTime;
    }

    public void setSolvedTime(LocalDateTime solvedTime) {
        SolvedTime = solvedTime;
    }
}
