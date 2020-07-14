package ru.plotnikov.advboard.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.model.AdvertisementService;

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
    Advertisement getById(@PathVariable int id) {
        return advService.getById(id);
    }
}
