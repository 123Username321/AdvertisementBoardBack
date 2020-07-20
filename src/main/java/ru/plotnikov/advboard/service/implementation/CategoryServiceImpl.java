package ru.plotnikov.advboard.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.model.Category;
import ru.plotnikov.advboard.model.SortParameters;
import ru.plotnikov.advboard.repository.CategoryRepository;
import ru.plotnikov.advboard.service.CategoryService;

import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository catRep;
    private final String[] validColumns = {"name", "title", "description", "add_date"};

    @Autowired
    public CategoryServiceImpl(CategoryRepository catRep) {
        this.catRep = catRep;
    }

    @Override
    public List<Category> getAll(Integer categoryTag, List<SortParameters> sortParameters) {
        return catRep.findAll(categoryTag, getSortQuery(sortParameters));
    }

    @Override
    public List<Category> getAllWithPaging(int pageNumber, int pageSize, Integer categoryTag,
                                    List<SortParameters> sortParameters) {
        return catRep.findAllWithPaging(categoryTag,
                PageRequest.of(pageNumber - 1, pageSize, getSortQuery(sortParameters)));
    }

    @Override
    public Category getById(int id) {
        return catRep.findById(id);
    }

    public int insert(String name) {
        Category newCat = new Category();

        newCat.setId(0);
        newCat.setName(name);

        return catRep.save(newCat).getId();
    }

    @Override
    @Transactional
    public void update(int id, String name) {
        Category tmpAdv = catRep.getOne(id);
        tmpAdv.setName(name);
        catRep.save(tmpAdv);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        catRep.deleteById(id);
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
