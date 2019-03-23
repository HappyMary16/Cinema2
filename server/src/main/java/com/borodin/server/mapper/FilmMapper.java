package com.borodin.server.mapper;

import com.borodin.server.dao.LanguageDao;
import com.borodin.server.domain.Film;
import org.springframework.jdbc.core.RowMapper;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmMapper implements RowMapper<Film> {
    @Override
    public Film mapRow(ResultSet rs, int i) throws SQLException {
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
    }
}
