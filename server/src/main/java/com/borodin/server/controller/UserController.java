package com.borodin.server.controller;


import java.util.List;

import com.borodin.server.dao.UserDao;
import com.borodin.server.domain.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/users")
public class UserController {

    private UserDao userDao = new UserDao();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable(value = "id") Long id) {
        return userDao.getById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        return userDao.create(user);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAll() {
        return userDao.getAll();
    }
}
