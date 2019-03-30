package com.borodin.server.dao;

import com.borodin.server.domain.Studio;
import com.borodin.server.mapper.StudioMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class StudioDao extends SimpleTableDao<Studio> {

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Studio entity) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_INSERT, new String[]{"id"});
            ps.setString(1, entity.getStudio());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    @Override
    public Studio update(Studio entity) {
        jdbcTemplate.update(SQL_UPDATE, entity.getStudio(), entity.getId());
        return entity;
    }

    @Override
    protected RowMapper<Studio> getRowMapper() {
        return StudioMapper.getStudioMapper();
    }

    @Override
    protected String getTypeName() {
        return "genre";
    }
}
