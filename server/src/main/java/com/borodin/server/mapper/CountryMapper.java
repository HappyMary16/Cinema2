package com.borodin.server.mapper;

import com.borodin.server.domain.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet rs, int i) throws SQLException {
        Country entity = new Country();
        entity.setId(rs.getLong("id"));
        entity.setCountry(rs.getString("genre"));
        return entity;
    }
}
