package ru.plotnikov.advboard.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Advertisement> getAll(@RequestParam(value = "title", required = false) String titleTag,
                                      @RequestParam(value = "description", required = false) String descriptionTag,
                                      @RequestParam(value = "start_timestamp", required = false) String startDate,
                                      @RequestParam(value = "end_timestamp", required = false) String endDate) {

        Timestamp startTimestamp = null;
        Timestamp endTimestamp = null;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            startTimestamp = new Timestamp(dateFormat.parse(startDate).getTime());
            endTimestamp = new Timestamp(dateFormat.parse(endDate).getTime());
        } catch (Exception e) {
            return null;
        }

        System.out.println(startTimestamp.toString() + "   " + endTimestamp.toString());

        return advService.getAll(titleTag, descriptionTag, startTimestamp, endTimestamp);
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
