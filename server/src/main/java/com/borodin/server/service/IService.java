package com.borodin.server.service;

import java.util.List;

public interface IService<K, V> {

    List<V> getAll();

    V findById(K id);

    void deleteById(K id);

    void update(V entity);

    V create(V entity);
}
