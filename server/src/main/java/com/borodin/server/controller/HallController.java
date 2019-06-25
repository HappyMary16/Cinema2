package com.borodin.server.controller;

import com.borodin.server.domain.Hall;
import com.borodin.server.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/halls")
public class HallController {

    @Autowired
    private IService<Long, Hall> hallService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Hall getHall(@PathVariable(value = "id") Long id) {
        Hall hall =  hallService.findById(id);
        System.out.println(hall);
        return hall;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Hall saveHall(@RequestBody Hall hall) {
        return hallService.create(hall);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Hall> getAll() {
        return hallService.getAll();
    }
}
