package com.borodin.server.dao;

import java.util.List;

public interface IDao <K, V>{

    List<V> getAll();

    V getById(K id);

    void deleteById(K id);

    V update(V entity);

    V create(V entity);
}
