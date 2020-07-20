package com.example.Springbootpractice.demo.DAO;

import com.example.Springbootpractice.demo.Model.Person;

import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID ID, Person person);

    default  int addPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
}
