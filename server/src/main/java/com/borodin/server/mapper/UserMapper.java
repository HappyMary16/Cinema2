package com.borodin.server.mapper;

import com.borodin.server.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User entity = new User();
        entity.setId(rs.getLong("id"));
        entity.setFirstName(rs.getString("first_name"));
        entity.setLastName(rs.getString("last_name"));
        entity.setLogin(rs.getString("login"));
        entity.setPassword(rs.getString("password"));
        entity.setPhone(rs.getString("phone"));
        entity.setEmail(rs.getString("email"));
        entity.setRoleId(rs.getLong("role_id"));
        return entity;
    }
}
