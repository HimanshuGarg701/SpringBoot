package com.example.Springbootpractice.demo.serviceLayer;

import com.example.Springbootpractice.demo.DAO.PersonDao;
import com.example.Springbootpractice.demo.Model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonDao personDao;

    public PersonService(@Qualifier("personDao") PersonDao personDao){
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
}
