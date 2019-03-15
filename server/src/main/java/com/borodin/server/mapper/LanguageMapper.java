package com.borodin.server.mapper;

import com.borodin.server.domain.Language;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LanguageMapper implements RowMapper<Language> {
    @Override
    public Language mapRow(ResultSet rs, int i) throws SQLException {
        Language entity = new Language();
        entity.setId(rs.getLong("id"));
        entity.setLanguage(rs.getString("language"));
        return entity;
    }
}
