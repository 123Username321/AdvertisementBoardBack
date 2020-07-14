package ru.plotnikov.advboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.service.CommonService;
import ru.plotnikov.advboard.service.implementation.AdvertisementService;

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
    Advertisement getById(@PathVariable int id) {
        return advService.getById(id);
    }
}
