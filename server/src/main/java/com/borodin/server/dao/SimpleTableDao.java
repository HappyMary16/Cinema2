package com.borodin.server.dao;

import com.borodin.server.domain.Entity;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public abstract class SimpleTableDao<T extends Entity> extends Dao<T> {

    protected String SQL_UPDATE = "UPDATE " +
            getTypeName() +
            " SET " +
            getTypeName() +
            " = ? WHERE id = ?";
    protected String SQL_INSERT = "INSERT INTO " +
            getTypeName() + " (" +
            getTypeName() + ") VALUES (?)";

    @Override
    public T create(T entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> createInsertStatement(connection, entity), keyHolder);

        entity.setId(keyHolder.getKey().longValue());

        return entity;
    }

    @Override
    public void deleteById(Long id) {
        throw new IllegalStateException();
    }

    protected abstract PreparedStatement createInsertStatement(Connection connection, T entity);
}
