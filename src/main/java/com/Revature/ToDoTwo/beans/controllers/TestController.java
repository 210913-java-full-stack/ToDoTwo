package com.Revature.ToDoTwo.beans.controllers;

import com.Revature.ToDoTwo.beans.entities.TestEntity;
import com.Revature.ToDoTwo.beans.services.TestEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/ToDoTwo")
public class TestController {
    private final TestEntityService service;

    @Autowired
    public TestController(TestEntityService service) {
        this.service = service;
    }



    //get method - retrieve a resource
    @GetMapping(value = "/TestEntity", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<TestEntity> getTestEntity() {
        return service.getAll();
    }

    //post method - persist a new resource
    @PostMapping(value = "/TestEntity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public TestEntity newTestEntity(@RequestBody TestEntity newEntity) {
        service.save(newEntity);
        return service.getById(newEntity.getId());
    }
}
