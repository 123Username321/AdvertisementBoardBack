package ru.plotnikov.advboard.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AdvertisementRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public AdvertisementRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Advertisement> findAll() {
        List<Advertisement> results = jdbcTemplate.query(
                "SELECT * FROM advertisement", new Object[] {},
                new RowMapper<Advertisement>() {
                    @Override
                    public Advertisement mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Advertisement(rs.getInt("id"), rs.getString("title"),
                                rs.getString("description"), rs.getTimestamp("add_date"));
                    }
                });
        return results;
    }

    /*
    public void save(Advertisement advertisement) {
        String sql = "INSERT INTO advertisement VALUES (DEFAULT, ?, ?, ?)";
        jdbcTemplate.update(sql, advertisement.getTitle(), advertisement.getDescription(), advertisement.getAddTime());
    }

    public List<Advertisement> loadAll() {
        return jdbcTemplate.query("SELECT * FROM advertisement", (resultSet, i) -> {
            return toAdvertisement(resultSet);
        });
    }

    private Advertisement toAdvertisement(ResultSet resultSet) throws SQLException {
        return new Advertisement(resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getString("description"),
                resultSet.getTimestamp("add_date"));
    }

    /*
    public List<Advertisement> findAll() {
        return jdbcTemplate.query("SELECT * FROM advertisement", new BeanPropertyRowMapper<>(Advertisement.class));
    }

    public Advertisement findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM cities WHERE id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(Advertisement.class));
    }
    */
}

