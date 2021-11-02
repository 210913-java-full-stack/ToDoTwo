package com.Revature.ToDoTwo.beans.repositories;

import com.Revature.ToDoTwo.beans.entities.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestEntityRepository extends JpaRepository<TestEntity, Integer> {
    /*
    Extending the CrudRepository should implement the following CRUD operations for us:
    save()
    saveAll()
    findById()
    existsById()
    findAll()
    findAllById()
    count()
    deleteById()
    delete()
    deleteAll()
     */

    //we can also write our own methods here, for instance JPQL queries that are more
    //complex than the options we have above.

}
