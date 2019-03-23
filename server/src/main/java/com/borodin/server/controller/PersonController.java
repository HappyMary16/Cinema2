package com.borodin.server.controller;

import com.borodin.server.dao.PersonDao;
import com.borodin.server.domain.Genre;
import com.borodin.server.domain.Person;
import com.borodin.server.domain.User;
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

    @RequestMapping(value = "/all_actors", method = RequestMethod.GET)
    public List<Person> getAllActors() {
        return personDao.findAllBy("role_id", "4");
    }

    @RequestMapping(value = "/all_directors", method = RequestMethod.GET)
    public List<Person> getAllDirector() {
        return personDao.findAllBy("role_id", "3");
    }

    @RequestMapping(value = "/by_name/{name}", method = RequestMethod.GET)
    public Person getByName(@PathVariable(value = "name") String name) {
        System.out.println(name);
        List<Person> people = personDao.findAllBy(new String[][]{{"first_name", name.split("  ")[0]}
                , {"last_name", name.split("  ")[1]}});
        if (people.isEmpty()) {
            return null;
        } else {
            return people.get(0);
        }
    }

}
