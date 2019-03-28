package com.borodin.server.service;

import com.borodin.server.dao.FilmDao;
import com.borodin.server.dao.FilmDataDao;
import com.borodin.server.domain.*;
import com.borodin.server.mapper.CountryMapper;
import com.borodin.server.mapper.GenreMapper;
import com.borodin.server.mapper.PersonMapper;
import com.borodin.server.mapper.StudioMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService implements IService<Long, Film> {

    private static FilmDao filmDao = new FilmDao();

    private static FilmDataDao<Genre> genreFilmDataDao = new FilmDataDao<Genre>() {
        @Override
        protected String getTypeName() {
            return "genre";
        }
    };

    private static FilmDataDao<Studio> studioFilmDataDao = new FilmDataDao<Studio>() {
        @Override
        protected String getTypeName() {
            return "studio";
        }
    };
    private static FilmDataDao<Person> actorFilmDataDao = new FilmDataDao<Person>() {
        @Override
        protected String getTypeName() {
            return "actor";
        }
    };

    private static FilmDataDao<Person> directorFilmDataDao = new FilmDataDao<Person>() {
        @Override
        protected String getTypeName() {
            return "director";
        }
    };
    private static FilmDataDao<Country> countryFilmDataDao = new FilmDataDao<Country>() {
        @Override
        protected String getTypeName() {
            return "country";
        }
    };

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
        film.setGenres(genreFilmDataDao.getAllByFilmId(film.getId(), GenreMapper.getGenreMapper()));
        film.setCountries(countryFilmDataDao.getAllByFilmId(film.getId(), CountryMapper.getCountryMapper()));
        film.setStudios(studioFilmDataDao.getAllByFilmId(film.getId(), StudioMapper.getStudioMapper()));
        film.setActors(actorFilmDataDao.getAllByFilmId(film.getId(), PersonMapper.getPersonMapper()));
        film.setDirectors(directorFilmDataDao.getAllByFilmId(film.getId(), PersonMapper.getPersonMapper()));
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
