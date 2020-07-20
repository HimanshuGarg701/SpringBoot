package com.example.Springbootpractice.demo.ApiLayer;

import com.example.Springbootpractice.demo.Model.Person;
import com.example.Springbootpractice.demo.serviceLayer.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    public void addPerson(Person person){
        personService.addPerson(person);
    }
}
