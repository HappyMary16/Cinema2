package com.borodin.server.dao;

import com.borodin.server.domain.Entity;

import java.util.List;

public interface IDao <K, V extends Entity>{

    List<V> getAll();

    V findById(K id);

    void deleteById(K id);

    V update(V entity);

    V create(V entity);
    
    List<V> findAllBy(String columnName, String value);
}
