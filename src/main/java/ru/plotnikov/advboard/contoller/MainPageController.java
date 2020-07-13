package ru.plotnikov.advboard.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.DriverManager;

@Controller
public class MainPageController {

    @RequestMapping("/")
    @ResponseBody
    String index() {
        return "Hello, world";
    }
}
