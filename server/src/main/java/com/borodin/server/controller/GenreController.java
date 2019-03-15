package com.borodin.server.controller;

import com.borodin.server.dao.GenreDao;
import com.borodin.server.domain.Genre;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/genres")
public class GenreController {

    private GenreDao genreDao = new GenreDao();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Genre getGenre(@PathVariable(value = "id") Long id) {
        return genreDao.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Genre saveGenre(@RequestBody Genre genre) {
        return genreDao.create(genre);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Genre> getAll() {
        return genreDao.getAll();
    }
}
