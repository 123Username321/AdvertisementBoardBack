package ru.plotnikov.advboard.controller;

import java.awt.print.Pageable;
import java.sql.SQLOutput;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.model.AdvertisementRequest;
import ru.plotnikov.advboard.model.PagingResult;
import ru.plotnikov.advboard.service.AdvertisementService;

@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {
    private final AdvertisementService advService;

    @Autowired
    public AdvertisementController(AdvertisementService advService) {
        this.advService = advService;
    }

    @GetMapping("/list")
    public List<Advertisement> getAll() {
        return advService.getAll();
    }

    @GetMapping(value = "/list", params = {"page_number", "page_size"})
    public PagingResult<Advertisement> getWithPaging(@RequestParam("page_number") int pageNumber,
                                                     @RequestParam("page_size") int pageSize) {
        if (pageNumber < 1) {
            pageNumber = 1;
        }
        if (pageSize < 1) {
            pageSize = 10;
        }

        return advService.getWithPaging(pageNumber, pageSize);
    }

    @GetMapping("/{id}")
    public Advertisement getById(@PathVariable int id) {
        return advService.getById(id);
    }

    @PostMapping("/add")
    public int create(@RequestBody AdvertisementRequest advertisementRequest) {
        return advService.insert(advertisementRequest);
    }

    @PutMapping("/{id}")
    void modifyById(@PathVariable int id, @RequestBody AdvertisementRequest advertisementRequest) {
        advService.update(id, advertisementRequest);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable int id) {
        advService.delete(id);
    }
}
