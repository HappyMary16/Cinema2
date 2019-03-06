package com.borodin.server.service;

import java.util.List;

public interface IService<K, V> {

    List<V> getAll();

    V getById(K id);

    void deleteById(K id);

    void update(V entity);

    void create(V entity);
}
