package com.borodin.server.controller;

import com.borodin.server.dao.CountryDao;
import com.borodin.server.domain.Country;
import com.borodin.server.domain.Genre;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/countries")
public class CountryController {

    private CountryDao countryDao = new CountryDao();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Country getCountry(@PathVariable(value = "id") Long id) {
        return countryDao.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Country saveCountry(@RequestBody Country country) {
        return countryDao.create(country);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Country> getAll() {
        return countryDao.getAll();
    }

    @RequestMapping(value = "/by_name/{name}", method = RequestMethod.GET)
    public Country getByName(@PathVariable(value = "name") String name) {
        List<Country> countries = countryDao.findAllBy("country", name);
        if (countries.isEmpty()) {
            return null;
        } else {
            return countries.get(0);
        }
    }
}