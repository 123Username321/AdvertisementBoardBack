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

    @GetMapping(value = "/list")
    public List<Advertisement> getAll() {
        return advService.getAll();
    }

    @GetMapping(value = "/list", params = {"page", "size"})
    public PagingResult<Advertisement> getWithPaging(@RequestParam(required = false) Integer pageNumber,
                                                     @RequestParam(required = false) Integer pageSize) {
        if (pageNumber != null && pageSize != null)
            return advService.getWithPaging(pageNumber, pageSize);
        else return null;
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
