package com.borodin.server.dao;

import com.borodin.server.domain.Seance;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class SeanceDao extends Dao<Seance> {

    @Override
    public Seance update(Seance entity) {
        String SQL = "UPDATE seance " +
                "SET film_id = ?, hall_id = ?, price = ?, date_and_time = ? " +
                "WHERE id = ?";

        jdbcTemplate.update(
                SQL,
                entity.getFilm().getId(),
                entity.getHall().getId(),
                entity.getPriceTicket(),
                entity.getDateAndTime(),
                entity.getId());

        return entity;
    }

    @Override
    public Seance create(Seance entity) {
        String SQL = "INSERT INTO seance (film_id, hall_id, price, date_and_time) " +
                "VALUES (?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps = null;
                    try {
                        ps = connection.prepareStatement(SQL, new String[]{"id"});
                        ps.setLong(1, entity.getFilm().getId());
                        ps.setLong(2, entity.getHall().getId());
                        ps.setLong(3, entity.getPriceTicket());
                        ps.setDate(4, new Date(entity.getDateAndTime().getTime()));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return ps;
                },
                keyHolder);

        entity.setId(keyHolder.getKey().longValue());

        return entity;
    }

    @Override
    protected RowMapper<Seance> getRowMapper() {
        return (rs, i) -> {
            Seance entity = new Seance();
            entity.setId(rs.getLong("id"));
            entity.setPriceTicket(rs.getInt("price"));
            entity.setDateAndTime(rs.getDate("date_and_time"));
            entity.setFilm(new FilmDao().findById(rs.getLong("film_id")));
            entity.setHall(new HallDao().findById(rs.getLong("hall_id")));
            return entity;
        };
    }

    @Override
    protected String getTypeName() {
        return "genre";
    }
}
