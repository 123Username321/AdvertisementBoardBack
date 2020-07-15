package ru.plotnikov.advboard.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.model.AdvertisementRequest;
import ru.plotnikov.advboard.repository.CommonRepository;
import ru.plotnikov.advboard.service.AdvertisementService;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    private final CommonRepository<Advertisement> advRepo;

    @Autowired
    public AdvertisementServiceImpl(@Qualifier("advertisementRepository") CommonRepository<Advertisement> advRepo) {
        this.advRepo = advRepo;
    }

    @Override
    public List<Advertisement> getAll() {
        return advRepo.findAll();
    }

    @Override
    public List<Advertisement> getWithPaging(int page, int amount) {
        return advRepo.findWithPaging(page, amount);
    }

    @Override
    public Advertisement getById(int id) {
        return advRepo.findById(id);
    }

    @Override
    public int insert(AdvertisementRequest advertisement) {
        return advRepo.insert(new Advertisement(0, advertisement.getTitle(), advertisement.getDescription(), null));
    }

    @Override
    public void update(int id, AdvertisementRequest advertisement) {
        advRepo.update(new Advertisement(id, advertisement.getTitle(), advertisement.getDescription(), null));
    }

    @Override
    public void delete(int id) {
        advRepo.delete(id);
    }
}
