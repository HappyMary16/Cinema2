package com.borodin.server.dao;

import com.borodin.server.domain.Language;
import com.borodin.server.mapper.LanguageMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LanguageDao extends SimpleTableDao<Language> {

    public LanguageDao() {
        super(Language.class, new LanguageMapper());
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Language entity) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_INSERT, new String[]{"id"});
            ps.setString(1, entity.getLanguage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    @Override
    public Language update(Language entity) {
        jdbcTemplateObject.update(SQL_UPDATE, entity.getLanguage(), entity.getId());
        return entity;
    }
}
