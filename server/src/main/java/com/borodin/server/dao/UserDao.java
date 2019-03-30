package com.borodin.server.dao;

import com.borodin.server.domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class UserDao extends Dao<User> {

    @Override
    public User update(User entity) {
        String SQL = "UPDATE user " +
                "SET first_name = ?, last_name = ?, login = ?, password = ?, phone = ?, email = ?, role_id = ? " +
                "WHERE id = ?";

        jdbcTemplate.update(
                SQL,
                entity.getFirstName(),
                entity.getLastName(),
                entity.getLogin(),
                entity.getPassword(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getRoleId(),
                entity.getId());

        return entity;
    }

    @Override
    public User create(User entity) {
        String SQL = "INSERT INTO user (first_name, last_name, login, password, phone, email, role_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps = null;
                    try {
                        ps = connection.prepareStatement(SQL, new String[]{"id"});
                        ps.setString(1, entity.getFirstName());
                        ps.setString(2, entity.getLastName());
                        ps.setString(3, entity.getLogin());
                        ps.setString(4, entity.getPassword());
                        ps.setString(5, entity.getPhone());
                        ps.setString(6, entity.getEmail());
                        ps.setLong(7, entity.getRoleId());
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
    protected RowMapper<User> getRowMapper() {
        return (rs, i) -> {
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
        };
    }

    @Override
    protected String getTypeName() {
        return "genre";
    }
}
