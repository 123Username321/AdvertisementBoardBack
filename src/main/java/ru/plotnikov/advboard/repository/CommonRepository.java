package ru.plotnikov.advboard.repository;

import java.util.List;

public interface CommonRepository<T> {
    List<T> findAll();
    List<T> findWithPaging(int page, int amount);
    T findById(int id);
    int insert(T entity);
    void update(T entity);
    void delete(int id);
}
