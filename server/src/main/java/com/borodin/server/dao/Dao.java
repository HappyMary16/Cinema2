package com.borodin.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public abstract class Dao <T> implements IDao<Long, T> {

    @Autowired
    private DataSource dataSource;

    protected JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);

    private String tableName;

    private final String SQL_DELETE_BY_ID;

    protected final String SQL_SELECT_ALL;

    protected final String SQL_SELECT_BY_ID;

    protected Dao(Class className) {
        tableName = className.getSimpleName();
        SQL_SELECT_ALL = String.format("SELECT * FROM %s", tableName);
        SQL_SELECT_BY_ID = String.format("SELECT * FROM %s WHERE id = ?", tableName);
        SQL_DELETE_BY_ID = String.format("DELETE FROM %s WHERE id = ?", tableName);
    }

    @Override
    public void deleteById(Long id) {
        String sql = String.format(SQL_DELETE_BY_ID, tableName);
        jdbcTemplateObject.update(sql, id);
    }
}
