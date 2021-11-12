package com.Revature.ToDoTwo.beans.services;

import com.Revature.ToDoTwo.beans.entities.TestEntity;
import com.Revature.ToDoTwo.beans.entities.ToDoItemEntity;
import com.Revature.ToDoTwo.beans.repositories.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ToDoItemService {
    private final ToDoItemRepository repo;

    @Autowired
    public ToDoItemService(ToDoItemRepository repo) {
        this.repo = repo;
    }

    //create and update
    public void save(ToDoItemEntity item) {
        repo.save(item);
    }


    //read
    public ToDoItemEntity getEntity(Integer id) {
        return repo.getById(id);
    }

    public List<ToDoItemEntity> getAllEntities() {
        return repo.findAll();
    }
}
