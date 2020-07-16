package ru.plotnikov.advboard.controller;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.model.AdvertisementRequest;
import ru.plotnikov.advboard.model.PagingResult;
import ru.plotnikov.advboard.model.SortParameters;
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
                                      @RequestParam(value = "start_timestamp", required = false) Timestamp startDate,
                                      @RequestParam(value = "end_timestamp", required = false) Timestamp endDate,
                                      @RequestParam(value = "sort", required = false) String sortParameter) {

        ObjectMapper objectMapper = new ObjectMapper();

        List<SortParameters> sortParameters;
        //sortParameters.add(new SortParameters("title", false));
        //sortParameters.add(new SortParameters("description", true));
        try {
            sortParameters = objectMapper.readValue(sortParameter, new TypeReference<List<SortParameters>>() {});
        }
        catch (Exception e) {
            return null;
        }

        return advService.getAll(titleTag, descriptionTag, startDate, endDate, sortParameters);
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
