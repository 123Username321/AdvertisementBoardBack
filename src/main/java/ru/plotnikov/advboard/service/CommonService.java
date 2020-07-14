package ru.plotnikov.advboard.service;

import java.util.List;

public interface CommonService<T> {
    List<T> getAll();
    T getById(int id);
}
