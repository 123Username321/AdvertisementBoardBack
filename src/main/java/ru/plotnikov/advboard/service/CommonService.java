package ru.plotnikov.advboard.service;

import java.util.List;

public interface CommonService<T> {
    List<T> getAll();
    T getById(int id);
    int insertEntity(T entity);
    void updateEntity(T entity);
    void deleteEntity(int id);
}
