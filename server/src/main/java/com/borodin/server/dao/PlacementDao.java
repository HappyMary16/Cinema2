package com.borodin.server.dao;

import com.borodin.server.mapper.PlacementMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PlacementDao implements IPlacementDao {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("DataSourceBean.xml");

    private static DataSource dataSource = (DataSource) context.getBean("dataSource");

    private static JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);

    private static final String SELECT_ALL_BY_HALL_ID = "SELECT * FROM placement WHERE hall_id = ?";

    private static final String INSERT_ALL_BY_HALL_ID = "INSERT INTO placement (hall_id, row_num, column_num) VALUES (?, ?, ?)";

    private static final String DELETE_ALL_BY_HALL_ID = "DELETE FROM placement WHERE hall_id = ?";

    @Override
    public List<Integer[]> getAll(Long hallId) {

        return jdbcTemplateObject.query(connection -> {
            PreparedStatement ps = null;
            try {
                ps = connection.prepareStatement(SELECT_ALL_BY_HALL_ID);
                ps.setLong(1, hallId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return ps;}, new PlacementMapper());
    }

    @Override
    public void insertAll(List<Integer[]> places, Long hallId) {
        for (Integer[] place :
                places) {
            jdbcTemplateObject.update(INSERT_ALL_BY_HALL_ID, hallId, place[0], place[1]);
        }

    }

    @Override
    public void deleteAll(Long id) {
        jdbcTemplateObject.update(DELETE_ALL_BY_HALL_ID, id);
    }

    @Override
    public void updateAll(List<Integer[]> places, Long id) {
        deleteAll(id);
        insertAll(places, id);
    }
}
