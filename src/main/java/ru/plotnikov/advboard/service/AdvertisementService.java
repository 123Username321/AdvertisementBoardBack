package ru.plotnikov.advboard.service;

import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.model.AdvertisementRequest;
import ru.plotnikov.advboard.model.PagingResult;

import java.sql.Timestamp;
import java.util.List;

public interface AdvertisementService {
    List<Advertisement> getAll(String titleTag, String descriptionTag, Timestamp startTimestamp, Timestamp endTimestamp);
    PagingResult<Advertisement> getWithPaging(int pageNumber, int pageSize);
    Advertisement getById(int id);
    int insert(AdvertisementRequest entity);
    void update(int id, AdvertisementRequest entity);
    void delete(int id);
}
