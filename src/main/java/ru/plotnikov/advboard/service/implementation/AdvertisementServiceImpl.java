package ru.plotnikov.advboard.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.model.AdvertisementRequest;
import ru.plotnikov.advboard.model.Category;
import ru.plotnikov.advboard.model.SortParameters;
import ru.plotnikov.advboard.repository.AdvertisementRepository;
import ru.plotnikov.advboard.service.AdvertisementService;

import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    private final AdvertisementRepository advRepo;
    private final String[] validColumns = {"title", "description", "addDateTime", "c.name"};

    @Autowired
    public AdvertisementServiceImpl(AdvertisementRepository advRepo) {
        this.advRepo = advRepo;
    }

    @Override
    public List<Advertisement> getAll(String titleTag, String descriptionTag, Integer categoryTag,
                                      Timestamp startTimestamp, Timestamp endTimestamp,
                                      List<SortParameters> sortParameters) {

        if (titleTag != null) {
            titleTag = "%" + titleTag + "%";
        }
        if (descriptionTag != null) {
            descriptionTag = "%" + descriptionTag + "%";
        }

        return advRepo.findAll(titleTag, descriptionTag, categoryTag, startTimestamp, endTimestamp,
                getSortQuery(sortParameters));
    }

    @Override
    public Page<Advertisement> getAllWithPaging(int pageNumber, int pageSize, String titleTag,
                                                String descriptionTag, Integer categoryTag,
                                                Timestamp startTimestamp, Timestamp endTimestamp,
                                                List<SortParameters> sortParameters) {

        if (titleTag != null) {
            titleTag = "%" + titleTag + "%";
        }
        if (descriptionTag != null) {
            descriptionTag = "%" + descriptionTag + "%";
        }

        return advRepo.findAllWithPaging(titleTag, descriptionTag, categoryTag, startTimestamp, endTimestamp,
                PageRequest.of(pageNumber - 1, pageSize, getSortQuery(sortParameters)));
    }

    @Override
    public Advertisement getById(int id) {
        return advRepo.findById(id);
    }

    @Override
    @Transactional
    public int insert(AdvertisementRequest advReq) {
        Advertisement newAdv = new Advertisement();

        newAdv.setId(0);
        newAdv.setCategory(new Category(advReq.getCategoryId(), null));
        newAdv.setTitle(advReq.getTitle());
        newAdv.setDescription(advReq.getDescription());
        newAdv.setAddDateTime(Timestamp.valueOf(LocalDateTime.now(Clock.systemDefaultZone())));

        return advRepo.save(newAdv).getId();
    }

    @Override
    @Transactional
    public void update(int id, AdvertisementRequest advReq) {
        Advertisement tmpAdv = advRepo.getOne(id);
        tmpAdv.setTitle(advReq.getTitle());
        tmpAdv.setDescription(advReq.getDescription());
        advRepo.save(tmpAdv);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        advRepo.deleteById(id);
    }


    private Sort getSortQuery(List<SortParameters> sortParameters) {

        List<Sort.Order> orders = new ArrayList<>();
        Set<String> columns = new HashSet<String>(Arrays.asList(this.validColumns));

        if (sortParameters != null) {
            for (SortParameters sortParameter : sortParameters) {
                if (columns.contains(sortParameter.getColumnName())) {
                    if (sortParameter.isDesc()) {
                        orders.add(new Sort.Order(Sort.Direction.DESC, sortParameter.getColumnName()));
                    }
                    else {
                        orders.add(new Sort.Order(Sort.Direction.ASC, sortParameter.getColumnName()));
                    }
                }
            }
        }

        orders.add(new Sort.Order(Sort.Direction.ASC, "id"));

        return Sort.by(orders);
    }
}
