package com.borodin.server.controller;

import com.borodin.server.dao.PersonDao;
import com.borodin.server.domain.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/persons")
public class PersonController {

    private PersonDao personDao = new PersonDao();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable(value = "id") Long id) {
        return personDao.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Person savePerson(@RequestBody Person person) {
        return personDao.create(person);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Person> getAll() {
        return personDao.getAll();
    }
}
