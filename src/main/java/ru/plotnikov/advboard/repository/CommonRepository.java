package ru.plotnikov.advboard.repository;

import java.util.List;

public interface CommonRepository<T> {
    List<T> findAll();
    T findById(int id);
    int insert(T entity);
    void update(int id, T entity);
    void delete(int id);
}
