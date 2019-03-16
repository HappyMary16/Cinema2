package com.borodin.server.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlacementMapper implements RowMapper<Integer[]> {

    @Override
    public Integer[] mapRow(ResultSet rs, int i) throws SQLException {
        Integer[] entity = new Integer[2];
        entity[0] = (rs.getInt("row_num"));
        entity[1] = (rs.getInt("column_num"));
        return entity;
    }
}
