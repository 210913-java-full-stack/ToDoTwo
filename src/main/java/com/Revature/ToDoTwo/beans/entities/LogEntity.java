package com.Revature.ToDoTwo.beans.entities;


import javax.persistence.*;

@Entity
public class LogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer warningLevel;

    @Column
    private String dataTime;

    @Column(columnDefinition = "varchar(20000)")
    private String message;

    public LogEntity() {

    }

    public LogEntity(String dataTime, String message, Integer warningLevel) {
        this.dataTime = dataTime;
        this.message = message;
        this.warningLevel = warningLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getWarningLevel() {
        return warningLevel;
    }

    public void setWarningLevel(Integer warningLevel) {
        this.warningLevel = warningLevel;
    }
}
