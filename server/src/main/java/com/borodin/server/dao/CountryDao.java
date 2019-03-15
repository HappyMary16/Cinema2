package com.borodin.server.dao;

import com.borodin.server.domain.Country;
import com.borodin.server.mapper.CountryMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class CountryDao extends SimpleTableDao<Country> {

    public CountryDao() {
        super(Country.class, new CountryMapper());
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Country entity) {
        return null;
    }

    @Override
    public Country update(Country entity) {
        return null;
    }
}
