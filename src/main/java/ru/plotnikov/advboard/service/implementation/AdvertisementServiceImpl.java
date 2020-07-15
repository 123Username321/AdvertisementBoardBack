package ru.plotnikov.advboard.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.model.AdvertisementRequest;
import ru.plotnikov.advboard.model.PagingResult;
import ru.plotnikov.advboard.repository.AdvertisementRepository;
import ru.plotnikov.advboard.service.AdvertisementService;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    private final AdvertisementRepository advRepo;

    @Autowired
    public AdvertisementServiceImpl(@Qualifier("advertisementRepositoryImpl") AdvertisementRepository advRepo) {
        this.advRepo = advRepo;
    }

    @Override
    public List<Advertisement> getAll(String titleTag, String descriptionTag,
                                      Timestamp startTimestamp, Timestamp endTimestamp) {
        return advRepo.findAll(titleTag, descriptionTag, startTimestamp, endTimestamp);
    }

    @Override
    public PagingResult<Advertisement> getWithPaging(int pageNumber, int pageSize) {
        return advRepo.findWithPaging(pageNumber, pageSize);
    }

    @Override
    public Advertisement getById(int id) {
        return advRepo.findById(id);
    }

    @Override
    @Transactional
    public int insert(AdvertisementRequest advertisement) {
        return advRepo.insert(new Advertisement(0, advertisement.getTitle(), advertisement.getDescription(), null));
    }

    @Override
    @Transactional
    public void update(int id, AdvertisementRequest advertisement) {
        advRepo.update(new Advertisement(id, advertisement.getTitle(), advertisement.getDescription(), null));
    }

    @Override
    @Transactional
    public void delete(int id) {
        advRepo.delete(id);
    }
}
