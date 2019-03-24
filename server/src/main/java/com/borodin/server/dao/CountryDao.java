package com.borodin.server.dao;

import com.borodin.server.domain.Country;
import com.borodin.server.mapper.CountryMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class CountryDao extends SimpleTableDao<Country> {

    public CountryDao() {
        super(Country.class, new CountryMapper());
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Country entity) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_INSERT, new String[]{"id"});
            ps.setString(1, entity.getCountry());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    @Override
    public Country update(Country entity) {
        jdbcTemplateObject.update(SQL_UPDATE, entity.getCountry(), entity.getId());
        return entity;
    }
}