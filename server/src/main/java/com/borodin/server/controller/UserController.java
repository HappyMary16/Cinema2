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
        return userDao.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        return userDao.create(user);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAll() {
        return userDao.getAll();
    }

    @RequestMapping(value = "/all_users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userDao.findAllBy("role_id", "2");
    }

    @RequestMapping(value = "/all_admins", method = RequestMethod.GET)
    public List<User> getAllAdmins() {
        return userDao.findAllBy("role_id", "1");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public User updateUser(@RequestBody User user) {
        return userDao.update(user);
    }

}
