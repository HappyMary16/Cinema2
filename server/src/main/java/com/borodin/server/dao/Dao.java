package com.borodin.server.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class Dao <T> implements IDao<Long, T> {

     private static ApplicationContext context = new ClassPathXmlApplicationContext("DataSourceBean.xml");

     protected static DataSource dataSource =
            (DataSource) context.getBean("dataSource");

    protected static JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);

    private String tableName;

    private RowMapper<T> mapper;

    private final String SQL_DELETE_BY_ID;

    protected final String SQL_SELECT_ALL;

    protected final String SQL_SELECT_BY_ID;

    protected final String SQL_SELECT_ALL_BY_COLUMN;

    protected Dao(Class className, RowMapper<T> mapper) {
        this.mapper = mapper;
        tableName = className.getSimpleName();
        SQL_SELECT_ALL = String.format("SELECT * FROM %s", tableName);
        SQL_SELECT_BY_ID = String.format("SELECT * FROM %s WHERE id = ?", tableName);
        SQL_DELETE_BY_ID = String.format("DELETE FROM %s WHERE id = ?", tableName);
        SQL_SELECT_ALL_BY_COLUMN = String.format("SELECT * FROM %s WHERE %s = ?", tableName, "%s");
    }

    @Override
    public List<T> getAll() {
        return jdbcTemplateObject.query(SQL_SELECT_ALL, mapper);
    }

    @Override
    public T findById(Long id) {
        return jdbcTemplateObject.queryForObject(SQL_SELECT_BY_ID, new Object[]{id}, mapper);
    }

    @Override
    public void deleteById(Long id) {
        String sql = String.format(SQL_DELETE_BY_ID, tableName);
        jdbcTemplateObject.update(sql, id);
    }


    @Override
    public List<T> findAllBy(String columnName, String value) {
        String SQL = String.format(SQL_SELECT_ALL_BY_COLUMN, columnName);

        return jdbcTemplateObject.query(connection -> {
            PreparedStatement ps = null;

            try {
                ps = connection.prepareStatement(SQL);
                ps.setString(1, value);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return ps;
        }, mapper);
    }
}
