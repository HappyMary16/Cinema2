package com.borodin.server.dao;

import com.borodin.server.domain.Entity;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public interface IFilmDataDao<T extends Entity> {

    void insertDataByFilmId(List<T> data, int filmId);

    List<T> getAllByFilmId(int filmId, RowMapper<T> mapper);

    void deleteAllByFilmId(int filmId);

    void updateAllByFilmId(int filmId, List<T> newData);
}
