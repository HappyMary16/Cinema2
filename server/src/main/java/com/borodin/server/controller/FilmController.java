package com.borodin.server.controller;

import com.borodin.server.domain.Film;
import com.borodin.server.service.FilmService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/films")
public class FilmController {

    private FilmService filmService = new FilmService();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Film getFilm(@PathVariable(value = "id") Long id) {
        return filmService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Film saveFilm(@RequestBody Film film) {
        return filmService.create(film);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Film> getAll() {
        return filmService.getAll();
    }
}
