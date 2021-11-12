package com.Revature.ToDoTwo.beans.entities;

import javax.persistence.*;

@Entity
public class ToDoItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String message;

    @Column
    private Boolean complete;

    public ToDoItemEntity() {
    }

    public ToDoItemEntity(String message, boolean complete) {
        this.message = message;
        this.complete = complete;
    }

    public ToDoItemEntity(Integer id, String message, boolean complete) {
        this.id = id;
        this.message = message;
        this.complete = complete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean isComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "ToDoItemEntity{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", complete=" + complete +
                '}';
    }
}
