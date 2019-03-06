package com.borodin.server.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

public abstract class Dao <T> implements IDao<Long, T> {


     private static ApplicationContext context = new ClassPathXmlApplicationContext("DataSourceBean.xml");

     private static DataSource dataSource =
            (DataSource) context.getBean("dataSource");

    protected static JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);

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
