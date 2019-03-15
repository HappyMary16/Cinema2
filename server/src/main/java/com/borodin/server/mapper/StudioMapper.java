package com.borodin.server.mapper;

import com.borodin.server.domain.Country;
import com.borodin.server.domain.Studio;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudioMapper implements RowMapper<Studio> {
    @Override
    public Studio mapRow(ResultSet rs, int i) throws SQLException {
        Studio entity = new Studio();
        entity.setId(rs.getLong("id"));
        entity.setStudio(rs.getString("genre"));
        return entity;
    }
}
