package ru.plotnikov.advboard.repository.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.model.PagingResult;
import ru.plotnikov.advboard.repository.CommonRepository;

import java.awt.print.Pageable;
import java.sql.*;
import java.util.ArrayList;
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
    public PagingResult<Advertisement> findWithPaging(int page, int amount) {
        RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
        jdbcTemplate.query("SELECT * FROM advertisement", countCallback);
        System.out.println(countCallback.getRowCount());

        return jdbcTemplate.query(
                "SELECT id, title, description, add_date, COUNT(*) OVER() AS \"total_count\" FROM advertisement LIMIT ?, ?",
                new Object[]{(page - 1) * amount, amount},
                new ResultSetExtractor<PagingResult<Advertisement>>() {
                    @Override
                    public PagingResult<Advertisement> extractData(ResultSet rs) throws SQLException, DataAccessException {
                        List<Advertisement> list = new ArrayList<Advertisement>();
                        int count = 0;
                        while (rs.next()) {
                            list.add(new Advertisement(rs.getInt(1),
                                                       rs.getString(2),
                                                       rs.getString(3),
                                                       rs.getTimestamp(4)));
                            count = rs.getInt(5);
                        }
                        return new PagingResult<Advertisement>(count, page, amount, list);
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

