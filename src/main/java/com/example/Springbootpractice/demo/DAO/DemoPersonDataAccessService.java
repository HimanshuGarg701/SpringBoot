package com.example.Springbootpractice.demo.DAO;

import com.example.Springbootpractice.demo.Model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
            //Failed to add person to database
            return -1;
        }
    }
}
