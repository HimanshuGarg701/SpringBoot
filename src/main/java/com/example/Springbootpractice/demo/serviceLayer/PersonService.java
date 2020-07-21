package com.example.Springbootpractice.demo.serviceLayer;

import com.example.Springbootpractice.demo.DAO.PersonDao;
import com.example.Springbootpractice.demo.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("personDao") PersonDao personDao){
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.getPerson();
    }

    public int updatePerson(UUID id, Person updatedPerson){
        return personDao.updatePerson(id, updatedPerson);
    }

    public int deletePerson(UUID id){
        return personDao.deletePerson(id);
    }


}
