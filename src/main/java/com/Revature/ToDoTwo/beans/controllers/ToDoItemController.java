package com.Revature.ToDoTwo.beans.controllers;

import com.Revature.ToDoTwo.beans.entities.ToDoItemEntity;
import com.Revature.ToDoTwo.beans.services.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ToDoTwo")
public class ToDoItemController {
    private final ToDoItemService service;

    @Autowired
    public ToDoItemController(ToDoItemService service) {
        this.service = service;
    }

    @CrossOrigin//default opens up all origins, and GET POST and HEAD methods
    @GetMapping(value = "/ToDoItems", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ToDoItemEntity> getAllToDoItems() {
        return service.getAllEntities();
    }

    //default opens up all origins, and GET POST and HEAD methods
    @GetMapping(value = "/ToDoItems/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ToDoItemEntity getToDoItemById(@PathVariable Integer id) {
        return service.getEntity(id);
    }

    @CrossOrigin//default opens up all origins, and GET POST and HEAD methods
    @PostMapping(value = "/ToDoItems", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ToDoItemEntity saveToDoEntity(@RequestBody ToDoItemEntity entity) {
        System.out.println(entity);
        service.save(entity);
        return service.getEntity(entity.getId());
        //maybe breaks if there's not an ID? I think it should save an auto generated ID to the original entity upon saving
    }
}
