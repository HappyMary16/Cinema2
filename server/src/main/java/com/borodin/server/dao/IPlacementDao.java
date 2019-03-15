package com.borodin.server.dao;

import java.util.List;

public interface IPlacementDao {

    List<Integer[]> getAll(Long hallId);

    void insertAll(List<Integer[]> places, Long hallId);

    void deleteAll(Long hallId);

    void updateAll(List<Integer[]> places, Long hallId);
}
