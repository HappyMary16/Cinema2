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
        System.out.println(seanceDao.findById(id));
        return seanceDao.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Seance saveSeance(@RequestBody Seance seance) {
        boolean check = true;

        for (Seance s :
                seanceDao.findAllBy("hall_id", String.valueOf(seance.getHall().getId()))) {
            long dateEnd = seance.getDateAndTime().getTime() + (seance.getFilm().getDuration() + 10) * 60 * 1000;
            long sFilmEnd = s.getDateAndTime().getTime() + (s.getFilm().getDuration() + 10) * 60 * 1000;
            if ((seance.getDateAndTime().getTime() > s.getDateAndTime().getTime()
                    && seance.getDateAndTime().getTime() < sFilmEnd)
                    || (dateEnd > s.getDateAndTime().getTime()
                    && dateEnd < sFilmEnd)) {
                check = false;
            }
        }

        if (check) {
            seanceDao.create(seance);
        }
        return seance;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Seance> getAll() {
        return seanceDao.getAll();
    }
}
