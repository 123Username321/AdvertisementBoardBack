package ru.plotnikov.advboard.service;

import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.model.AdvertisementRequest;

import java.util.List;

public interface AdvertisementService {
    List<Advertisement> getAll();
    Advertisement getById(int id);
    int insert(AdvertisementRequest entity);
    void update(int id, AdvertisementRequest entity);
    void delete(int id);
}
