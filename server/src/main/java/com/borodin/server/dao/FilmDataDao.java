package com.borodin.server.dao;

import com.borodin.server.domain.Entity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class FilmDataDao<T extends Entity> implements IFilmDataDao<T> {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("DataSourceBean.xml");

    protected static DataSource dataSource = (DataSource) context.getBean("dataSource");

    protected static JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);

    private String type;

    public static final String GET_ALL_BY_ID = "SELECT * FROM film_%s INNER JOIN %s ON film_%s = id WHERE film_id = ?";
    public static final String DELETE_ALL_BY_ID = "DELETE FROM film_%s WHERE film_id = ?";
    public static final String INSERT_ALL_BY_ID = "INSERT INTO film_%s (film_id, %s_id) VALUES (?, ?)";

    public FilmDataDao(String tableType) {
        this.type = tableType;
    }

    @Override
    public void insertDataByFilmId(List<T> data, Long filmId) {
        String SQL = String.format(INSERT_ALL_BY_ID, type, type);

        for (Entity entity :
                data) {
            jdbcTemplateObject.update(
                    connection -> {
                        PreparedStatement ps = null;
                        try {
                            ps = connection.prepareStatement(SQL);
                            ps.setLong(1, filmId);
                            ps.setLong(2, entity.getId());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        return ps;
                    });
        }
    }

    @Override
    public List<T> getAllByFilmId(Long filmId, RowMapper<T> mapper) {
        String sql = String.format(GET_ALL_BY_ID, type,
                (type.equalsIgnoreCase("actor")
                        || type.equalsIgnoreCase("director")
                        ? "person" : type), type);

        return jdbcTemplateObject.query(connection -> {
            PreparedStatement ps = null;
            try {
                ps = connection.prepareStatement(sql);
                ps.setLong(1, filmId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return ps;
        }, mapper);
    }

    @Override
    public void deleteAllByFilmId(Long filmId) {
        String sql = String.format(DELETE_ALL_BY_ID, type);
        jdbcTemplateObject.update(sql, filmId);
    }

    @Override
    public void updateAllByFilmId(Long filmId, List<T> newData) {
        deleteAllByFilmId(filmId);
        insertDataByFilmId(newData, filmId);
    }
}
