package ru.plotnikov.advboard.service;

import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.model.AdvertisementRequest;
import ru.plotnikov.advboard.model.PagingResult;
import ru.plotnikov.advboard.model.SortParameters;

import java.sql.Timestamp;
import java.util.List;

public interface AdvertisementService {
    List<Advertisement> getAll(String titleTag, String descriptionTag, Timestamp startTimestamp, Timestamp endTimestamp,
                               List<SortParameters> sortParameters);
    PagingResult<Advertisement> getWithPaging(int pageNumber, int pageSize, String titleTag, String descriptionTag,
                                              Timestamp startTimestamp, Timestamp endTimestamp,
                                              List<SortParameters> sortParameters);
    Advertisement getById(int id);
    int insert(AdvertisementRequest entity);
    void update(int id, AdvertisementRequest entity);
    void delete(int id);
}
