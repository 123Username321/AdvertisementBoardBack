package ru.plotnikov.advboard.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementService implements CommonService<Advertisement> {
    private final AdvertisementRepository advRepo;

    @Autowired
    public AdvertisementService(AdvertisementRepository advRepo) {
        this.advRepo = advRepo;
    }

    @Override
    public List<Advertisement> getAll() {
        return advRepo.findAll();
    }

    @Override
    public Advertisement getById(int id) {
        return advRepo.findById(id);
    }
}
