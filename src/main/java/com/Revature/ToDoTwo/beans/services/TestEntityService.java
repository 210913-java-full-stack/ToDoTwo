package com.Revature.ToDoTwo.beans.services;

import com.Revature.ToDoTwo.beans.entities.TestEntity;
import com.Revature.ToDoTwo.beans.repositories.TestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TestEntityService {
    //note that we can make this field final, as the autowiring is done on the constructor.
    private final TestEntityRepository repo;

    @Autowired
    public TestEntityService(TestEntityRepository repo) {
        this.repo = repo;
    }

    public void save(TestEntity entity) {
        repo.save(entity);
    }

    public TestEntity getById(Integer id) {
        return repo.getById(id);
    }

    public List<TestEntity> getAll() {
        return repo.findAll();
    }

    public List<TestEntity> getSome() {
        return repo.findAll().stream().filter(p -> p.getId() <= 50).collect(Collectors.toList());
    }
}
