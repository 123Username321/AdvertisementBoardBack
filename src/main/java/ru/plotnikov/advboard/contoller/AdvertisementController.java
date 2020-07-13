package ru.plotnikov.advboard.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdvertisementController {
    @RequestMapping("/advertisement/{id}")
    @ResponseBody
    String index(@PathVariable int id) {
        return String.valueOf(id);
    }
}
