package ru.plotnikov.advboard.repository;

import ru.plotnikov.advboard.model.PagingResult;

import java.util.List;

public interface CommonRepository<T> {
    List<T> findAll(String tag);
    PagingResult<T> findWithPaging(int pageNumber, int pageSize);
    T findById(int id);
    int insert(T entity);
    void update(T entity);
    void delete(int id);
}
