package com.borodin.server.dao;

import com.borodin.server.domain.User;
import com.borodin.server.mapper.UserMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao extends Dao<User> {

    public UserDao() {
        super(User.class);
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplateObject.query(SQL_SELECT_ALL, new UserMapper());
    }

    @Override
    public User getById(Long id) {
        return jdbcTemplateObject.queryForObject(SQL_SELECT_BY_ID, new Object[]{id}, new UserMapper());
    }

    @Override
    public User update(User entity) {
        String SQL = "UPDATE user " +
                "SET first_name = ?, last_name = ?, login = ?, password = ?, phone = ?, email = ?, role_id = ? " +
                "WHERE id = ?";

        jdbcTemplateObject.update(
                SQL,
                entity.getFirstName(),
                entity.getLastName(),
                entity.getLogin(),
                entity.getPassword(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getRole().getId(),
                entity.getId());

        return getById(entity.getId());
    }

    @Override
    public User create(User entity) {
        String SQL = "INSERT INTO user (first_name, last_name, login, password, phone, email, role_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";


        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplateObject.update(
                connection ->  {
                        PreparedStatement ps =
                                null;
                        try {
                            ps = connection.prepareStatement(SQL, new String[]{"id"});
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        try {
                            ps.setString(1, entity.getFirstName());
                            ps.setString(2, entity.getLastName());
                            ps.setString(3, entity.getLogin());
                            ps.setString(4, entity.getPassword());
                            ps.setString(5, entity.getPhone());
                            ps.setString(6, entity.getEmail());
                            ps.setInt(7, entity.getRole().getId());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        return ps;
                    },
                keyHolder);

        return getById(keyHolder.getKey().longValue());
    }
}
