package ru.plotnikov.advboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.model.AdvertisementRequest;
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

    @GetMapping("/{id}")
    public Advertisement getById(@PathVariable int id) {
        return advService.getById(id);
    }

    @PostMapping("/add")
    public int create(@RequestBody AdvertisementRequest advertisement) {
        return advService.insert(new AdvertisementRequest(advertisement.getTitle(), advertisement.getDescription()));
    }

    @PutMapping("/{id}")
    void modifyById(@PathVariable int id, @RequestBody AdvertisementRequest advertisement) {
        advService.update(id, new AdvertisementRequest(advertisement.getTitle(), advertisement.getDescription()));
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable int id) {
        advService.delete(id);
    }
}
