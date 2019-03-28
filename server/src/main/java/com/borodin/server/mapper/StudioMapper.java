package com.borodin.server.mapper;

import com.borodin.server.domain.Studio;
import org.springframework.jdbc.core.RowMapper;

public class StudioMapper {
    public static RowMapper<Studio> getStudioMapper() {
        return (rs, i) -> {
            Studio entity = new Studio();
            entity.setId(rs.getLong("id"));
            entity.setStudio(rs.getString("studio"));
            return entity;
        };
    }
}
