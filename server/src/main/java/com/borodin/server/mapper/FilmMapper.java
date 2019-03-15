package com.borodin.server.mapper;

import com.borodin.server.domain.Film;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmMapper implements RowMapper<Film> {
    @Override
    public Film mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}
