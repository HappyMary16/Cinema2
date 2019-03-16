package com.borodin.server.controller;

import com.borodin.server.dao.SeanceDao;
import com.borodin.server.domain.Seance;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/seances")
public class SeanceController {

    private SeanceDao seanceDao = new SeanceDao();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Seance getSeance(@PathVariable(value = "id") Long id) {
        return seanceDao.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Seance saveSeance(@RequestBody Seance seance) {
        return seanceDao.create(seance);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Seance> getAll() {
        return seanceDao.getAll();
    }
}
