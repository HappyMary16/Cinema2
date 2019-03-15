package com.borodin.server.dao;

import com.borodin.server.domain.Genre;
import com.borodin.server.mapper.GenreMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class GenreDao extends SimpleTableDao<Genre> {

    public GenreDao() {
        super(Genre.class, new GenreMapper());
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Genre entity) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_INSERT, new String[]{"id"});
            ps.setString(1, entity.getGenre());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    @Override
    public Genre update(Genre entity) {
        jdbcTemplateObject.update(SQL_UPDATE, entity.getGenre(), entity.getId());
        return entity;
    }
}
