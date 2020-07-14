package ru.plotnikov.advboard.contoller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.plotnikov.advboard.model.Advertisement;

@Controller
public class AdvertisementController {
    //AdvertisementRepository advRepo;

    @RequestMapping("/advertisement/")
    @ResponseBody
    String getAll() {
        //advRepo = new AdvertisementRepository();
        //advRepo.findAll();
        //advRepo.loadAll();

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUsername("sa");
        dataSource.setUrl("jdbc:h2:mem:testdb");
        dataSource.setPassword("");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Advertisement> results = jdbcTemplate.query(
                "SELECT * FROM advertisement", new Object[] {},
                new RowMapper<Advertisement>() {
                    @Override
                    public Advertisement mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Advertisement(rs.getInt("id"), rs.getString("title"),
                                rs.getString("description"), rs.getTimestamp("add_date"));
                    }
                });

        String html = "<!DOCTYPE html><html><head></head><body><table>";

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
        return "<!DOCTYPE html><html><head></head><body><h1>" + id + "</h1></body></html>";
    }
}
