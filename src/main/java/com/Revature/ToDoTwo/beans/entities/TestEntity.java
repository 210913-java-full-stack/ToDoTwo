package com.Revature.ToDoTwo.beans.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/*
JSON for this entity will look like:
{
    "id":1,
    "string":"some string"
}
 */


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TestEntity implements Serializable {
    @Id
    private Integer id;

    @Column
    private String string;

    public TestEntity() {
    }

    public TestEntity(Integer id, String string) {
        this.id = id;
        this.string = string;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }


}
