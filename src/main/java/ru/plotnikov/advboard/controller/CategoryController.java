package ru.plotnikov.advboard.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.plotnikov.advboard.model.Category;
import ru.plotnikov.advboard.model.SortParameters;
import ru.plotnikov.advboard.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService catService;

    @Autowired
    public CategoryController(CategoryService catService) {
        this.catService = catService;
    }

    @GetMapping("/list")
    @CrossOrigin("*")
    public ResponseEntity<List<Category>> getAll(@RequestParam(value = "id", required = false) Integer id,
                                                 @RequestParam(value = "sort", required = false) String sortParameterJson) {

        List<SortParameters> sortParameters = null;

        try {
            sortParameters = SortParameters.fromString(sortParameterJson);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(catService.getAll(id, sortParameters));
    }

    @GetMapping(value = "/list", params = {"page_number", "page_size"})
    @CrossOrigin("*")
    public ResponseEntity<List<Category>> getAllWithPaging(@RequestParam("page_number") int pageNumber,
                                                 @RequestParam("page_size") int pageSize,
                                                 @RequestParam(value = "id", required = false) Integer id,
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

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(catService.getAllWithPaging(pageNumber, pageSize, id, sortParameters));
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<Category> getById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(catService.getById(id));
    }

    @PostMapping("/add")
    @CrossOrigin("*")
    public ResponseEntity<String> insert(@RequestBody String name) {
        return ResponseEntity.status(HttpStatus.OK).body("Success insert, id: " + catService.insert(name));
    }

    @PutMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<String> updateById(@PathVariable int id, @RequestBody String name) {
        catService.update(id, name);
        return ResponseEntity.status(HttpStatus.OK).body("Success update");
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        catService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Success delete");
    }
}
