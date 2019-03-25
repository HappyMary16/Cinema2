package com.borodin.server.dao;

import com.borodin.server.domain.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public abstract class Dao<T extends Entity> implements IDao<Long, T> {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("DataSourceBean.xml");

    protected static DataSource dataSource =
            (DataSource) context.getBean("dataSource");

    protected static JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);

    private final String SQL_DELETE_BY_ID = "DELETE FROM %s WHERE id = ?";

    protected final String SQL_SELECT_ALL = "SELECT * FROM %s";

    protected final String SQL_SELECT_BY_ID = "SELECT * FROM %s WHERE id = ?";

    protected final String SQL_SELECT_ALL_BY_COLUMN = "SELECT * FROM %s WHERE %s = ?";

    @Override
    public List<T> getAll() {
        return jdbcTemplateObject.query(
                String.format(SQL_SELECT_ALL, getClassObject().getClass().getSimpleName()),
                getRowMapper());
    }

    @Override
    public T findById(Long id) {
        return jdbcTemplateObject.queryForObject(
                String.format(SQL_SELECT_BY_ID, getClassObject().getClass().getSimpleName()), new Object[]{id},
                getRowMapper());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplateObject.update(
                String.format(SQL_DELETE_BY_ID,
                        getClassObject().getClass().getSimpleName()), id);
    }


    @Override
    public List<T> findAllBy(String columnName, String value) {
        String SQL = String.format(
                String.format(SQL_SELECT_ALL_BY_COLUMN, getClassObject().getClass().getSimpleName(), "%s"),
                columnName);

        return jdbcTemplateObject.query(connection -> {
            PreparedStatement ps = null;

            try {
                ps = connection.prepareStatement(SQL);
                ps.setString(1, value);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return ps;
        }, getRowMapper());
    }

    @Override
    public List<T> findAllBy(String[][] columnAndValue) {
        if (columnAndValue.length == 0 || columnAndValue[0].length == 0) {
            return null;
        }

        String SQL = String.format(
                String.format(SQL_SELECT_ALL_BY_COLUMN, getClassObject().getClass().getSimpleName(), "%s"),
                columnAndValue[0][0]);
        StringBuilder sql = new StringBuilder(SQL);

        for (int i = 1; i < columnAndValue.length; i++) {
            sql.append( "AND ").append(columnAndValue[i][0]).append(" = ?");
        }

        return jdbcTemplateObject.query(connection -> {
            PreparedStatement ps = null;

            try {
                ps = connection.prepareStatement(SQL);
                for (String[] line :
                        columnAndValue) {
                    if (line.length < 2) {
                        continue;
                    }
                    ps.setString(1, line[1]);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return ps;
        }, getRowMapper());
    }

    protected abstract T getClassObject();

    protected abstract RowMapper<T> getRowMapper();
}
