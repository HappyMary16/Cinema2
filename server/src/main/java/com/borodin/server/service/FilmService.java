package com.borodin.server.service;

import com.borodin.server.dao.FilmDao;
import com.borodin.server.dao.FilmDataDao;
import com.borodin.server.domain.*;
import com.borodin.server.mapper.CountryMapper;
import com.borodin.server.mapper.GenreMapper;
import com.borodin.server.mapper.PersonMapper;
import com.borodin.server.mapper.StudioMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService implements IService<Long, Film> {

    private static FilmDao filmDao = new FilmDao();
    private static FilmDataDao<Genre> genreFilmDataDao = new FilmDataDao("genre");
    private static FilmDataDao<Studio> studioFilmDataDao = new FilmDataDao("studio");
    private static FilmDataDao<Person> actorFilmDataDao = new FilmDataDao("actor");
    private static FilmDataDao<Person> directorFilmDataDao = new FilmDataDao("director");
    private static FilmDataDao<Country> countryFilmDataDao = new FilmDataDao("country");

    @Override
    public List<Film> getAll() {
        List<Film> films = filmDao.getAll();

        for (Film film :
                films) {
            setFilmData(film);
        }

        return films;
    }

    @Override
    public Film create(Film entity) {
        filmDao.create(entity);

        System.out.println("film entity created");
        genreFilmDataDao.insertDataByFilmId(entity.getGenres(), entity.getId());
        actorFilmDataDao.insertDataByFilmId(entity.getActors(), entity.getId());
        countryFilmDataDao.insertDataByFilmId(entity.getCountries(), entity.getId());
        directorFilmDataDao.insertDataByFilmId(entity.getDirectors(), entity.getId());
        studioFilmDataDao.insertDataByFilmId(entity.getStudios(), entity.getId());

        return entity;
    }

    @Override
    public Film findById(Long key) {
        Film film = filmDao.findById(key);
        setFilmData(film);
        return film;
    }

    private void setFilmData(Film film) {
        film.setGenres(genreFilmDataDao.getAllByFilmId(film.getId(), new GenreMapper()));
        film.setCountries(countryFilmDataDao.getAllByFilmId(film.getId(), new CountryMapper()));
        film.setStudios(studioFilmDataDao.getAllByFilmId(film.getId(), new StudioMapper()));
        film.setActors(actorFilmDataDao.getAllByFilmId(film.getId(), new PersonMapper()));
        film.setDirectors(directorFilmDataDao.getAllByFilmId(film.getId(), new PersonMapper()));
    }

    @Override
    public void update(Film entity) {
        filmDao.update(entity);

        genreFilmDataDao.updateAllByFilmId(entity.getId(), entity.getGenres());
        studioFilmDataDao.updateAllByFilmId(entity.getId(), entity.getStudios());
        directorFilmDataDao.updateAllByFilmId(entity.getId(), entity.getDirectors());
        actorFilmDataDao.updateAllByFilmId(entity.getId(), entity.getActors());
        countryFilmDataDao.updateAllByFilmId(entity.getId(), entity.getCountries());
    }

    @Override
    public void deleteById(Long key) {
        filmDao.deleteById(key);
    }
}
