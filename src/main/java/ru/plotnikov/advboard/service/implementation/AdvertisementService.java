package ru.plotnikov.advboard.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.repository.implementation.AdvertisementRepository;
import ru.plotnikov.advboard.service.CommonService;

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
