package com.borodin.server.controller;

import com.borodin.server.domain.Film;
import com.borodin.server.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/films")
public class FilmController {

    @Autowired
    private IService<Long, Film> filmService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Film getFilm(@PathVariable(value = "id") Long id) {
        return filmService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Film saveFilm(@RequestBody Film film) {
        System.out.println("add");
        return filmService.create(film);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Film> getAll() {
        return filmService.getAll();
    }
}
