package ru.plotnikov.advboard.repository;

import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.model.PagingResult;

import java.sql.Timestamp;
import java.util.List;

public interface AdvertisementRepository {
    List<Advertisement> findAll(String titleTag, String descriptionTag, Timestamp startTimestamp, Timestamp endTimestamp);
    PagingResult<Advertisement> findWithPaging(int pageNumber, int pageSize);
    Advertisement findById(int id);
    int insert(Advertisement entity);
    void update(Advertisement entity);
    void delete(int id);
}
