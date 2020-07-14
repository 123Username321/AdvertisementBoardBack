package ru.plotnikov.advboard.model;

import java.util.List;

public interface IService<T> {
    List<T> getAll();
    T getById(int id);
}
