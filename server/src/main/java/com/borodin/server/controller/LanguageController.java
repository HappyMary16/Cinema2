package com.borodin.server.controller;

import com.borodin.server.dao.SimpleTableDao;
import com.borodin.server.domain.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/languages")
public class LanguageController {

    @Autowired
    private SimpleTableDao<Language> languageDao;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Language getLanguage(@PathVariable(value = "id") Long id) {
        return languageDao.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Language saveLanguage(@RequestBody Language language) {
        return languageDao.create(language);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Language> getAll() {
        return languageDao.getAll();
    }
}
