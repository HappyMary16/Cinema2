package com.borodin.server.mapper;

import com.borodin.server.domain.Genre;
import org.springframework.jdbc.core.RowMapper;

public class GenreMapper {
    public static RowMapper<Genre> getGenreMapper() {
        return (rs, i) -> {
            Genre entity = new Genre();
            entity.setId(rs.getLong("id"));
            entity.setGenre(rs.getString("genre"));
            return entity;
        };
    }
}
