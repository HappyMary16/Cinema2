package com.borodin.server.mapper;

import com.borodin.server.domain.Hall;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HallMapper implements RowMapper<Hall> {
    @Override
    public Hall mapRow(ResultSet rs, int i) throws SQLException {
        Hall entity = new Hall();
        entity.setId(rs.getLong("id"));
        entity.setHeight(rs.getInt("height"));
        entity.setWidth(rs.getInt("width"));
        entity.setName(rs.getString("hall_name"));
        return entity;
    }
}
