package ru.plotnikov.advboard.service;

import org.springframework.data.domain.Page;
import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.model.AdvertisementRequest;
import ru.plotnikov.advboard.model.SortParameters;

import java.sql.Timestamp;
import java.util.List;

public interface AdvertisementService {
    List<Advertisement> getAll(String titleTag, String descriptionTag, Timestamp startTimestamp, Timestamp endTimestamp,
                               List<SortParameters> sortParameters);

    Page<Advertisement> getAllWithPaging(int pageNumber, int pageSize, String titleTag, String descriptionTag,
                                         Timestamp startTimestamp, Timestamp endTimestamp,
                                         List<SortParameters> sortParameters);

    Advertisement getById(int id);
    int insert(AdvertisementRequest advReq);
    void update(int id, AdvertisementRequest entity);
    void deleteById(int id);
}
