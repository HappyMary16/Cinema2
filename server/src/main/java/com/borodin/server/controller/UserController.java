package com.borodin.server.controller;


import com.borodin.server.dao.UserDao;
import com.borodin.server.domain.User;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
