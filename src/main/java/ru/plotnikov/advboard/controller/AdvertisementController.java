package ru.plotnikov.advboard.controller;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.model.AdvertisementRequest;
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
    public ResponseEntity<List<Advertisement>> getAll(@RequestParam(value = "title", required = false) String titleTag,
                                                      @RequestParam(value = "description", required = false) String descriptionTag,
                                                      @RequestParam(value = "category", required = false) Integer categoryTag,
                                                      @RequestParam(value = "start_date", required = false) Timestamp startDate,
                                                      @RequestParam(value = "end_date", required = false) Timestamp endDate,
                                                      @RequestParam(value = "sort", required = false) String sortParameterJson) {

        List<SortParameters> sortParameters = null;

        try {
            sortParameters = SortParameters.fromString(sortParameterJson);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK)
                .header("Access-Control-Allow-Origin", "*")
                .body(advService.getAll(titleTag, descriptionTag, categoryTag, startDate, endDate, sortParameters));
    }

    @GetMapping(value = "/list", params = {"page_number", "page_size"})
    public ResponseEntity<Page<Advertisement>> getWithPaging(@RequestParam("page_number") int pageNumber,
                                                             @RequestParam("page_size") int pageSize,
                                                             @RequestParam(value = "title", required = false) String titleTag,
                                                             @RequestParam(value = "description", required = false) String descriptionTag,
                                                             @RequestParam(value = "category", required = false) Integer categoryTag,
                                                             @RequestParam(value = "start_date", required = false) Timestamp startDate,
                                                             @RequestParam(value = "end_date", required = false) Timestamp endDate,
                                                             @RequestParam(value = "sort", required = false) String sortParameterJson) {

        if (pageNumber < 1) {
            pageNumber = 1;
        }
        if (pageSize < 1) {
            pageSize = 10;
        }

        List<SortParameters> sortParameters = null;

        try {
            sortParameters = SortParameters.fromString(sortParameterJson);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).header("Access-Control-Allow-Origin", "*").body(advService.getAllWithPaging(
                pageNumber, pageSize, titleTag, descriptionTag, categoryTag, startDate, endDate, sortParameters));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Advertisement> getById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Access-Control-Allow-Origin", "*")
                .body(advService.getById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> insert(@RequestBody AdvertisementRequest advertisementRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Access-Control-Allow-Origin", "*")
                .body(advService.insert(advertisementRequest));
    }

    @PutMapping("/{id}")
    void modifyById(@PathVariable int id, @RequestBody AdvertisementRequest advertisementRequest) {
        advService.update(id, advertisementRequest);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable int id) {
        advService.deleteById(id);
    }
}
