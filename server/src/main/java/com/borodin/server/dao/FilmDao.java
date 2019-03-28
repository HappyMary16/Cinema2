package com.borodin.server.dao;

import com.borodin.server.domain.Film;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    protected RowMapper<Film> getRowMapper() {
        return (rs, i) -> {
            Film entity = new Film();
            entity.setId(rs.getLong("id"));
            entity.setTitle(rs.getString("title"));
            entity.setDescription(rs.getString("description"));
            entity.setYear(rs.getInt("year"));
            entity.setMinAge(rs.getInt("min_age"));
            entity.setDuration(rs.getInt("duration"));
            entity.setLanguage(new LanguageDao().findById(rs.getLong("film_language_id")));
            entity.setFirstSeance(rs.getDate("first_seance"));
            entity.setLastSeance(rs.getDate("last_seance"));
            entity.setSmallPoster(rs.getString("small_poster"));
            entity.setBigPoster(rs.getString("big_poster"));
            entity.setTrailerLink(rs.getString("trailer_link"));
            return entity;
        };
    }

    @Override
    protected String getTypeName() {
        return "film";
    }
}
