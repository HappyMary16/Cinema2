package com.borodin.server.mapper;

import com.borodin.server.domain.Person;
import org.springframework.jdbc.core.RowMapper;

public class PersonMapper {
    public static RowMapper<Person> getPersonMapper() {
        return (rs, i) -> {
            Person entity = new Person();
            entity.setId(rs.getLong("id"));
            entity.setFirstName(rs.getString("first_name"));
            entity.setLastName(rs.getString("last_name"));
            entity.setRoleId(rs.getLong("role_id"));
            return entity;
        };
    }
}
