package ru.plotnikov.advboard.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AdvertisementRepository implements CommonRepository<Advertisement> {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AdvertisementRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Advertisement> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM advertisement", new Object[] {},
                new RowMapper<Advertisement>() {
                    @Override
                    public Advertisement mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Advertisement(rs.getInt("id"), rs.getString("title"),
                                rs.getString("description"), rs.getTimestamp("add_date"));
                    }
                });
    }

    @Override
    public Advertisement findById(int id) {
        return jdbcTemplate.query(
                "SELECT * FROM advertisement WHERE id = ?", new Object[] { id },
                new RowMapper<Advertisement>() {
                    @Override
                    public Advertisement mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Advertisement(rs.getInt("id"), rs.getString("title"),
                                rs.getString("description"), rs.getTimestamp("add_date"));
                    }
                }).get(0);
    }
}

