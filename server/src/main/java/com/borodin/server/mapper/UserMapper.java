package com.borodin.server.mapper;

import com.borodin.server.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User entity = new User();
        entity.setId(resultSet.getLong("id"));
        entity.setFirstName(resultSet.getString("first_name"));
        entity.setLastName(resultSet.getString("last_name"));
        entity.setLogin(resultSet.getString("login"));
        entity.setPassword(resultSet.getString("password"));
        entity.setPhone(resultSet.getString("phone"));
        entity.setEmail(resultSet.getString("email"));
        //set role
        return entity;
    }
}
