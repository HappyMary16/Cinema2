package com.borodin.server.dao;

import com.borodin.server.domain.Film;
import com.borodin.server.mapper.FilmMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

@Repository
public class FilmDao extends Dao<Film> {

    @Override
    public Film update(Film entity) {
        String SQL = "UPDATE film " +
                "SET title = ?, description = ?, year = ?, min_age = ?, duration = ?, film_language_id = ?, " +
                "first_seance = ?, last_seance = ?, small_poster = ?, big_poster = ?, trailer_link = ? " +
                "WHERE id = ?";

        jdbcTemplateObject.update(
                SQL,
                entity.getTitle(),
                entity.getDescription(),
                entity.getYear(),
                entity.getMinAge(),
                entity.getDuration(),
                entity.getLanguage().getId(),
                entity.getFirstSeance(),
                entity.getLastSeance(),
                entity.getSmallPoster(),
                entity.getBigPoster(),
                entity.getTrailerLink(),
                entity.getId());

        return entity;
    }

    @Override
    public Film create(Film entity) {
        String SQL = "INSERT INTO film (title, description, year, min_age, duration, film_language_id, " +
                "first_seance, last_seance, small_poster, big_poster, trailer_link) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplateObject.update(
                connection -> {
                    PreparedStatement ps = null;
                    try {
                        ps = connection.prepareStatement(SQL, new String[]{"id"});
                        ps.setString(1, entity.getTitle());
                        ps.setString(2, entity.getDescription());
                        ps.setLong(3, entity.getYear());
                        ps.setLong(4, entity.getMinAge());
                        ps.setLong(5, entity.getDuration());
                        ps.setLong(6, entity.getLanguage().getId());
                        ps.setDate(7, new Date(entity.getFirstSeance().getTime()));
                        ps.setDate(8, new Date(entity.getLastSeance().getTime()));
                        ps.setString(9, entity.getSmallPoster());
                        ps.setString(10, entity.getBigPoster());
                        ps.setString(11, entity.getTrailerLink());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return ps;
                },
                keyHolder);

        entity.setId(keyHolder.getKey().longValue());

        return entity;
    }

    @Override
    protected Film getClassObject() {
        return new Film();
    }

    @Override
    protected RowMapper<Film> getRowMapper() {
        return new FilmMapper();
    }
}
