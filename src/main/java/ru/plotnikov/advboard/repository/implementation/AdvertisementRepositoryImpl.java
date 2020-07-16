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
import ru.plotnikov.advboard.model.SortParameters;
import ru.plotnikov.advboard.repository.AdvertisementRepository;

import java.sql.*;
import java.util.*;

@Repository
public class AdvertisementRepositoryImpl implements AdvertisementRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public AdvertisementRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Advertisement> findAll(String titleTag, String descriptionTag,
                                       Timestamp startTimestamp, Timestamp endTimestamp,
                                       List<SortParameters> sortParameters) {
        String sqlQuery = "SELECT * FROM advertisement" +
                " WHERE (:titleTag IS NULL OR title LIKE :titleTag) AND" +
                " (:descriptionTag IS NULL OR description LIKE :descriptionTag) AND" +
                " (:startTimestamp IS NULL OR add_date >= :startTimestamp) AND" +
                " (:endTimestamp IS NULL OR add_date <= :endTimestamp)" +
                " ORDER BY";

        Set<String> columns = new HashSet<String>(Arrays.asList("title", "description", "add_date"));

        if (sortParameters != null) {
            for (SortParameters sortParameter : sortParameters) {
                if (columns.contains(sortParameter.getColumnName())) {
                    sqlQuery += " " + sortParameter.getColumnName() + " " + (sortParameter.isDesc() ? "DESC" : "ASC") + ",";
                }
            }
        }

        sqlQuery += " id";

        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("titleTag", titleTag == null ? null : "%" + titleTag + "%", Types.VARCHAR)
                .addValue("descriptionTag",
                        descriptionTag == null ? null : "%" + descriptionTag + "%",
                        Types.VARCHAR)
                .addValue("startTimestamp", startTimestamp, Types.TIMESTAMP)
                .addValue("endTimestamp", endTimestamp, Types.TIMESTAMP);

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

