package ru.plotnikov.advboard.repository.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.repository.CommonRepository;

import java.awt.print.Pageable;
import java.sql.*;
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
    public List<Advertisement> findWithPaging(int page, int amount) {
        RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
        jdbcTemplate.query("SELECT * FROM advertisement", countCallback);
        System.out.println(countCallback.getRowCount());

        return jdbcTemplate.query(
                "SELECT * FROM advertisement LIMIT ?, ?", new Object[] { (page - 1) * amount, amount },
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

    @Override
    public int insert(Advertisement advertisement) {
        String sqlQuery = "INSERT INTO advertisement VALUES (DEFAULT, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, advertisement.getTitle());
            ps.setString(2, advertisement.getDescription());
            ps.setString(3, (new Timestamp((new java.util.Date()).getTime())).toString());
            return ps;
        }, keyHolder);

        return keyHolder.getKey() != null ? keyHolder.getKey().intValue() : -1;
    }

    @Override
    public void update(Advertisement advertisement) {
        jdbcTemplate.update("UPDATE advertisement SET title = ?, description = ? WHERE id = ?",
                advertisement.getTitle(), advertisement.getDescription(), advertisement.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM advertisement WHERE id = ?", id);
    }
}

