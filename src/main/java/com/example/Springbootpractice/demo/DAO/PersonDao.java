package com.example.Springbootpractice.demo.DAO;

import com.example.Springbootpractice.demo.Model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID ID, Person person);

    default  int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> getPerson();

    Optional<Person> getPerson(UUID id);

    int updatePerson(UUID id, Person person);

    int deletePerson(UUID id);
}
