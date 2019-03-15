package com.borodin.server.dao;

import com.borodin.server.domain.Person;
import com.borodin.server.mapper.PersonMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class PersonDao extends Dao<Person> {

    public PersonDao() {
        super(Person.class, new PersonMapper());
    }

    @Override
    public Person update(Person entity) {
        String SQL = "UPDATE user " +
                "SET first_name = ?, last_name = ?, role_id = ? " +
                "WHERE id = ?";

        jdbcTemplateObject.update(
                SQL,
                entity.getFirstName(),
                entity.getLastName(),
                entity.getRoleId(),
                entity.getId());

        return entity;
    }

    @Override
    public Person create(Person entity) {
        String SQL = "INSERT INTO user (first_name, last_name, role_id) " +
                "VALUES (?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplateObject.update(
                connection -> {
                    PreparedStatement ps = null;
                    try {
                        ps = connection.prepareStatement(SQL, new String[]{"id"});
                        ps.setString(1, entity.getFirstName());
                        ps.setString(2, entity.getLastName());
                        ps.setLong(3, entity.getRoleId());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return ps;
                },
                keyHolder);

        entity.setId(keyHolder.getKey().longValue());

        return entity;
    }
}
