package com.borodin.server.mapper;

import com.borodin.server.domain.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet rs, int i) throws SQLException {
            Person entity = new Person();
            entity.setId(rs.getLong("id"));
            entity.setFirstName(rs.getString("first_name"));
            entity.setLastName(rs.getString("last_name"));
            entity.setRoleId(rs.getLong("role_id"));
            return entity;
    }
}
