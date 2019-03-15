package com.borodin.server.mapper;

import com.borodin.server.domain.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreMapper implements RowMapper<Genre> {

    @Override
    public Genre mapRow(ResultSet rs, int i) throws SQLException {
        Genre entity = new Genre();
        entity.setId(rs.getLong("id"));
        entity.setGenre(rs.getString("genre"));
        return entity;
    }
}
