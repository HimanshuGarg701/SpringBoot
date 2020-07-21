package com.example.Springbootpractice.demo.DAO;

import com.example.Springbootpractice.demo.Model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("personDao")
public class DemoPersonDataAccessService implements PersonDao{

    private ArrayList<Person> dataBase = new ArrayList<>();


    @Override
    public int insertPerson(UUID ID, Person person) {
        try{
            dataBase.add(new Person(ID, person.getName()));
            return 1;
        }catch(Exception e){
            //Failed to add person to database list
            return -1;
        }
    }

    @Override
    public List<Person> getPerson() {
        return dataBase;
    }

    @Override
    public Optional<Person> getPerson(UUID id) {
        return dataBase.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        Optional<Person> personToUpdate = getPerson(id);
        if(personToUpdate.isEmpty()){
            return 0;
        }
        int indexOfPersonToUpdate = dataBase.indexOf(personToUpdate.get());
        dataBase.set(indexOfPersonToUpdate, person);
        return 1;
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> personToDelete = getPerson(id);
        if(personToDelete.isEmpty()){
            return 0;
        }
        dataBase.remove(personToDelete.get());
        return 1;
    }
}
