package ru.plotnikov.advboard.service;

import org.springframework.data.jpa.repository.Query;

import ru.plotnikov.advboard.model.AdvertisementRequest;
import ru.plotnikov.advboard.model.Category;
import ru.plotnikov.advboard.model.SortParameters;

import java.sql.Timestamp;
import java.util.List;

public interface CategoryService {
    List<Category> getAll(Integer categoryTag, List<SortParameters> sortParameters);
    List<Category> getAllWithPaging(int pageNumber, int pageSize, Integer categoryTag, List<SortParameters> sortParameters);
    Category getById(int id);
    int insert(String name);
    void update(int id, String name);
    void deleteById(int id);
}
