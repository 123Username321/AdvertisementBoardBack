package ru.plotnikov.advboard.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.repository.CommonRepository;
import ru.plotnikov.advboard.service.CommonService;

import java.util.List;

@Service
public class AdvertisementService implements CommonService<Advertisement> {
    private final CommonRepository<Advertisement> advRepo;

    @Autowired
    public AdvertisementService(@Qualifier("advertisementRepository") CommonRepository<Advertisement> advRepo) {
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

    @Override
    public int insertEntity(Advertisement advertisement) {
        return advRepo.insert(advertisement);
    }

    @Override
    public void updateEntity(int id, Advertisement advertisement) {
        advRepo.update(id, advertisement);
    }

    @Override
    public void deleteEntity(int id) {
        advRepo.delete(id);
    }
}
