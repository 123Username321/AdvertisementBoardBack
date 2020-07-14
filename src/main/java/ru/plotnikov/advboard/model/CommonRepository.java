package ru.plotnikov.advboard.model;

import java.util.List;

public interface CommonRepository<T> {
    List<T> findAll();
    T findById(int id);
}
