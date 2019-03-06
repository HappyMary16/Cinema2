package com.borodin.server.dao;

import java.util.List;

public interface IDao <K, V>{

    List<V> getAll();

    V getById(K id);

    void deleteById(K id);

    void update(V entity);

    void create(V entity);
}
