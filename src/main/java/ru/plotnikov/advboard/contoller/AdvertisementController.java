package ru.plotnikov.advboard.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.model.AdvertisementService;

@Controller
public class AdvertisementController {
    private AdvertisementService advService;

    @Autowired
    public AdvertisementController(AdvertisementService advService) {
        this.advService = advService;
    }

    @RequestMapping("/advertisement/list")
    @ResponseBody
    String getAll() {
        List<Advertisement> results = advService.getAll();

        String html = "<!DOCTYPE html><html><head></head><body><table border=1>";

        for (Advertisement adv : results) {
            html += "<tr>";

            html += "<td>" + adv.getId() + "</td>";
            html += "<td>" + adv.getTitle() + "</td>";
            html += "<td>" + adv.getDescription() + "</td>";
            html += "<td>" + adv.getAddTime().toString() + "</td>";

            html += "</tr>";
        }

        html += "</table></body></html>";
        return html;
    }

    @RequestMapping("/advertisement/{id}")
    @ResponseBody
    String getById(@PathVariable int id) {
        Advertisement adv = advService.getById(id);

        String html = "<!DOCTYPE html><html><head></head><body><table border=1>";

        html += "<tr>";

        html += "<td>" + adv.getId() + "</td>";
        html += "<td>" + adv.getTitle() + "</td>";
        html += "<td>" + adv.getDescription() + "</td>";
        html += "<td>" + adv.getAddTime().toString() + "</td>";

        html += "</tr>";

        html += "</table></body></html>";
        return html;
    }
}
