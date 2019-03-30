package com.borodin.server.dao;

import com.borodin.server.domain.Hall;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class HallDao extends Dao<Hall> {

    @Override
    public Hall update(Hall entity) {
        String SQL = "UPDATE hall " +
                "SET hall_name = ?, width = ?, height = ? " +
                "WHERE id = ?";

        jdbcTemplate.update(
                SQL,
                entity.getName(),
                entity.getWidth(),
                entity.getHeight(),
                entity.getId());

        return entity;
    }

    @Override
    public Hall create(Hall entity) {
        String SQL = "INSERT INTO hall (hall_name, width, height) " +
                "VALUES (?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps = null;
                    try {
                        ps = connection.prepareStatement(SQL, new String[]{"id"});
                        ps.setString(1, entity.getName());
                        ps.setLong(2, entity.getWidth());
                        ps.setLong(3, entity.getHeight());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return ps;
                },
                keyHolder);

        entity.setId(keyHolder.getKey().longValue());

        return entity;
    }

    @Override
    protected RowMapper<Hall> getRowMapper() {
        return (rs, i) -> {
            Hall entity = new Hall();
            entity.setId(rs.getLong("id"));
            entity.setHeight(rs.getInt("height"));
            entity.setWidth(rs.getInt("width"));
            entity.setName(rs.getString("hall_name"));
            return entity;
        };
    }

    @Override
    protected String getTypeName() {
        return "hall";
    }
}
