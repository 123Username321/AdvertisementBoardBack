package ru.plotnikov.advboard.repository.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.plotnikov.advboard.model.Advertisement;
import ru.plotnikov.advboard.model.PagingResult;
import ru.plotnikov.advboard.repository.CommonRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AdvertisementRepository implements CommonRepository<Advertisement> {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public AdvertisementRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Advertisement> findAll(String tag) {
        String sqlQuery = "SELECT * FROM advertisement WHERE (:titleTag IS NULL OR title LIKE :titleTag);";

//        Map<String, Object> params = new HashMap<>();
//        params.put("titleTag", tag == null ? null : "%" + tag + "%");
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("titleTag", tag == null ? null : "%" + tag + "%", Types.VARCHAR);

        return jdbcTemplate.query(sqlQuery, params,
                new RowMapper<Advertisement>() {
                    @Override
                    public Advertisement mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Advertisement(rs.getInt("id"), rs.getString("title"),
                                rs.getString("description"), rs.getTimestamp("add_date"));
                    }
                });
    }

    @Override
    public PagingResult<Advertisement> findWithPaging(int pageNumber, int pageSize) {
        String sqlQuery = "SELECT id, title, description, add_date, COUNT(*) OVER() " +
                          "AS \"total_count\" FROM advertisement LIMIT :offset, :count";

//        Map<String, Object> params = new HashMap<>();
//        params.put("offset", (pageNumber - 1) * pageSize);
//        params.put("count", pageSize);
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("offset", (pageNumber - 1) * pageSize, Types.INTEGER)
                .addValue("count", pageSize, Types.INTEGER);

        return jdbcTemplate.query(sqlQuery, params,
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
                        return new PagingResult<Advertisement>(count, pageSize, pageNumber, list);
                    }
                });
    }

    @Override
    public Advertisement findById(int id) {
        String sqlQuery = "SELECT * FROM advertisement WHERE id = :id";

//        Map<String, Object> params = new HashMap<>();
//        params.put("id", id);
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id, Types.INTEGER);

        return jdbcTemplate.query(sqlQuery, params, new RowMapper<Advertisement>() {
                    @Override
                    public Advertisement mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Advertisement(rs.getInt("id"), rs.getString("title"),
                                rs.getString("description"), rs.getTimestamp("add_date"));
                    }
                }).get(0);
    }

    @Override
    public int insert(Advertisement advertisement) {
        String sqlQuery = "INSERT INTO advertisement VALUES (DEFAULT, :title, :description, NOW())";

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("title", advertisement.getTitle(), Types.VARCHAR)
                .addValue("description", advertisement.getDescription(), Types.VARCHAR);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(sqlQuery, parameterSource, keyHolder);

        return keyHolder.getKey() != null ? keyHolder.getKey().intValue() : -1;
    }

    @Override
    public void update(Advertisement advertisement) {
        String sqlQuery = "UPDATE advertisement SET title = :title, description = :description WHERE id = :id";

//        Map<String, Object> params = new HashMap<>();
//        params.put("title", advertisement.getTitle());
//        params.put("description", advertisement.getDescription());
//        params.put("id", advertisement.getId());
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("title", advertisement.getTitle(), Types.VARCHAR)
                .addValue("description", advertisement.getDescription(), Types.VARCHAR)
                .addValue("id", advertisement.getId(), Types.INTEGER);

        jdbcTemplate.update(sqlQuery, params);
    }

    @Override
    public void delete(int id) {
        String sqlQuery = "DELETE FROM advertisement WHERE id = :id";

//        Map<String, Object> params = new HashMap<>();
//        params.put("id", id);
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id, Types.INTEGER);

        jdbcTemplate.update(sqlQuery, params);
    }
}

