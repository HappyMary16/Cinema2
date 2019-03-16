package com.borodin.server.dao;

import com.borodin.server.domain.Hall;
import com.borodin.server.mapper.HallMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class HallDao extends Dao<Hall> {

    public HallDao() {
        super(Hall.class, new HallMapper());
    }

    @Override
    public Hall update(Hall entity) {
        String SQL = "UPDATE hall " +
                "SET hall_name = ?, width = ?, height = ? " +
                "WHERE id = ?";

        jdbcTemplateObject.update(
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

        jdbcTemplateObject.update(
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
}
