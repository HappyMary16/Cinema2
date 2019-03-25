package com.borodin.server.dao;

import com.borodin.server.domain.Seance;
import com.borodin.server.mapper.SeanceMapper;
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

        jdbcTemplateObject.update(
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

        jdbcTemplateObject.update(
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
    protected Seance getClassObject() {
        return new Seance();
    }

    @Override
    protected RowMapper<Seance> getRowMapper() {
        return new SeanceMapper();
    }
}
