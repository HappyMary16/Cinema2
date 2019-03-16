package com.borodin.server.mapper;

import com.borodin.server.dao.FilmDao;
import com.borodin.server.dao.HallDao;
import com.borodin.server.domain.Seance;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SeanceMapper implements RowMapper<Seance> {
    @Override
    public Seance mapRow(ResultSet rs, int i) throws SQLException {
        Seance entity = new Seance();
        entity.setId(rs.getLong("id"));
        entity.setPriceTicket(rs.getInt("price"));
        entity.setDateAdnTime(rs.getDate("date_and_time"));
        entity.setFilm(new FilmDao().findById(rs.getLong("film_id")));
        entity.setHall(new HallDao().findById(rs.getLong("hall_id")));
        return entity;
    }
}
