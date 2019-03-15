package com.borodin.server.controller;

import com.borodin.server.dao.StudioDao;
import com.borodin.server.domain.Studio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/studios")
public class StudioController {

    private StudioDao studioDao = new StudioDao();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Studio getStudio(@PathVariable(value = "id") Long id) {
        return studioDao.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Studio saveStudio(@RequestBody Studio studio) {
        return studioDao.create(studio);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Studio> getAll() {
        return studioDao.getAll();
    }
}
