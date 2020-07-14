package ru.plotnikov.advboard.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.model.AdvertisementRequest;
import ru.plotnikov.advboard.service.CommonService;

@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {
    private final CommonService<Advertisement> advService;

    @Autowired
    public AdvertisementController(@Qualifier("advertisementService") CommonService<Advertisement> advService) {
        this.advService = advService;
    }

    @GetMapping("/list")
    public List<Advertisement> getAll() {
        return advService.getAll();
    }

    @GetMapping("/{id}")
    public Advertisement getById(@PathVariable int id) {
        return advService.getById(id);
    }

    @PostMapping("/add")
    public int create(@RequestBody AdvertisementRequest advertisement) {
        return advService.insertEntity(new Advertisement(0, advertisement.getTitle(),
                advertisement.getDescription(), null));
    }

    @PutMapping("/{id}")
    void modifyById(@PathVariable int id, @RequestBody AdvertisementRequest advertisement) {
        advService.updateEntity(new Advertisement(id, advertisement.getTitle(),
                advertisement.getDescription(), null));
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable int id) {
        advService.deleteEntity(id);
    }
}
