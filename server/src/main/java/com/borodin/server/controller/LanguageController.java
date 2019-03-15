package com.borodin.server.controller;

import com.borodin.server.dao.LanguageDao;
import com.borodin.server.domain.Language;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/languages")
public class LanguageController {

    private LanguageDao languageDao = new LanguageDao();

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
