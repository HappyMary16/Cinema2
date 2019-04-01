package com.borodin.server.dao;

import com.borodin.server.domain.Entity;
import com.borodin.server.mapper.PlacementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PlacementDao extends Dao<Integer[]> {

    private static final String SELECT_ALL_BY_HALL_ID = "SELECT * FROM placement WHERE hall_id = ?";

    private static final String INSERT_ALL_BY_HALL_ID = "INSERT INTO placement (hall_id, row_num, column_num) VALUES (?, ?, ?)";

    private static final String DELETE_ALL_BY_HALL_ID = "DELETE FROM placement WHERE hall_id = ?";

    public List<Integer[]> findAllByHallId(Long hallId) {

        return findAllBy("hall_id", String.valueOf(hallId));
//        return jdbcTemplate.query(connection -> {
//            PreparedStatement ps = null;
//            try {
//                ps = connection.prepareStatement(SELECT_ALL_BY_HALL_ID);
//                ps.setLong(1, hallId);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return ps;}, new PlacementMapper());
    }

    public void insertAll(List<Integer[]> places, Long hallId) {
        for (Integer[] place :
                places) {
            jdbcTemplate.update(INSERT_ALL_BY_HALL_ID, hallId, place[0], place[1]);
        }

    }

    public void deleteAll(Long id) {
        jdbcTemplate.update(DELETE_ALL_BY_HALL_ID, id);
    }

    public void updateAll(List<Integer[]> places, Long id) {
        deleteAll(id);
        insertAll(places, id);
    }

    @Override
    protected RowMapper<Integer[]> getRowMapper() {
        return null;
    }

    @Override
    protected String getTypeName() {
        return "placement";
    }

    @Override
    public Integer[] update(Integer[] entity) {
        return new Integer[0];
    }

    @Override
    public Integer[] create(Integer[] entity) {
        return new Integer[0];
    }
}
