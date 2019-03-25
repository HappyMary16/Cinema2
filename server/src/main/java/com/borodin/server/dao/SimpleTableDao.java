package com.borodin.server.dao;

import com.borodin.server.domain.Entity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class SimpleTableDao<T extends Entity> extends Dao<T> {

    protected final String SQL_UPDATE;
    protected final String SQL_INSERT;

    public SimpleTableDao() {
        SQL_UPDATE = "UPDATE " +
                getClassObject().getClass().getSimpleName().toLowerCase() +
                " SET " +
                getClassObject().getClass().getSimpleName().toLowerCase() +
                " = ? WHERE id = ?";
        SQL_INSERT = "INSERT INTO " +
                getClassObject().getClass().getSimpleName().toLowerCase() + " (" +
                getClassObject().getClass().getSimpleName().toLowerCase() + ") VALUES (?)";
    }

    @Override
    public T create(T entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplateObject.update(connection -> createInsertStatement(connection, entity), keyHolder);

        entity.setId(keyHolder.getKey().longValue());

        return entity;
    }

    @Override
    public void deleteById(Long id) {
        throw new IllegalStateException();
    }

    protected abstract PreparedStatement createInsertStatement(Connection connection, T entity);
}
