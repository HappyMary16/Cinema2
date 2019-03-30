package com.borodin.server.dao;

import com.borodin.server.domain.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public abstract class FilmDataDao<T extends Entity> extends Dao<T> implements IFilmDataDao<T> {

    public static final String GET_ALL_BY_ID = "SELECT * FROM film_%s INNER JOIN %s ON %s_id = id WHERE film_id = ?";
    public static final String DELETE_ALL_BY_ID = "DELETE FROM film_%s WHERE film_id = ?";
    public static final String INSERT_ALL_BY_ID = "INSERT INTO film_%s (film_id, %s_id) VALUES (?, ?)";

    @Override
    public void insertDataByFilmId(List<T> data, Long filmId) {
        String SQL = String.format(INSERT_ALL_BY_ID, getTypeName(), getTypeName());

        for (Entity entity :
                data) {
            jdbcTemplate.update(
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
        String sql = String.format(GET_ALL_BY_ID, getTypeName(),
                (getTypeName().equalsIgnoreCase("actor")
                        || getTypeName().equalsIgnoreCase("director")
                        ? "person" : getTypeName()), getTypeName());

        return jdbcTemplate.query(connection -> {
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
        String sql = String.format(DELETE_ALL_BY_ID, getTypeName());
        jdbcTemplate.update(sql, filmId);
    }

    @Override
    public void updateAllByFilmId(Long filmId, List<T> newData) {
        deleteAllByFilmId(filmId);
        insertDataByFilmId(newData, filmId);
    }

    protected abstract String getTypeName();

    @Override
    protected RowMapper<T> getRowMapper() {
        return null;
    }

    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public T create(T entity) {
        return null;
    }
}
