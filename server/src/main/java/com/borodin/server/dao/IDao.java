package com.borodin.server.dao;

import java.util.List;

public interface IDao <K, V>{

    List<V> getAll();

    V findById(K id);

    void deleteById(K id);

    V update(V entity);

    V create(V entity);
    
    List<V> findAllBy(String columnName, String value);
}
