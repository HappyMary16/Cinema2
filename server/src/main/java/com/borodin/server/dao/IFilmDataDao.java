package com.borodin.server.dao;

import com.borodin.server.domain.Entity;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public interface IFilmDataDao<T extends Entity> {

    void insertDataByFilmId(List<T> data, Long filmId);

    List<T> getAllByFilmId(Long filmId, RowMapper<T> mapper);

    void deleteAllByFilmId(Long filmId);

    void updateAllByFilmId(Long filmId, List<T> newData);
}
