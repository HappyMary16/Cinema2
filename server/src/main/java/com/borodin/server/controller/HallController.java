package com.borodin.server.controller;

import com.borodin.server.dao.HallDao;
import com.borodin.server.domain.Hall;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/halls")
public class HallController {

    private HallDao hallDao = new HallDao();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Hall getHall(@PathVariable(value = "id") Long id) {
        return hallDao.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Hall saveHall(@RequestBody Hall hall) {
        return hallDao.create(hall);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Hall> getAll() {
        return hallDao.getAll();
    }
}
