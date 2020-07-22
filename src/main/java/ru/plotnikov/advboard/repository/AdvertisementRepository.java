package ru.plotnikov.advboard.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.plotnikov.advboard.model.Advertisement;

import java.sql.Timestamp;
import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {
    @Query("SELECT a FROM Advertisement a JOIN a.category c" +
        " WHERE (:titleTag IS NULL OR a.title LIKE :titleTag) AND" +
        " (:descriptionTag IS NULL OR a.description LIKE :descriptionTag) AND" +
        " (:categoryTag IS NULL OR c.id = :categoryTag) AND" +
        " (:startTimestamp IS NULL OR a.addDateTime >= :startTimestamp) AND" +
        " (:endTimestamp IS NULL OR a.addDateTime <= :endTimestamp)")
    List<Advertisement> findAll(@Param("titleTag") String titleTag,
                                @Param("descriptionTag") String descriptionTag,
                                @Param("categoryTag") Integer categoryTag,
                                @Param("startTimestamp") Timestamp startTimestamp,
                                @Param("endTimestamp") Timestamp endTimestamp, Sort sort);

    
    @Query("SELECT a FROM Advertisement a JOIN a.category c" +
            " WHERE (:titleTag IS NULL OR a.title LIKE :titleTag) AND" +
            " (:descriptionTag IS NULL OR a.description LIKE :descriptionTag) AND" +
            " (:categoryTag IS NULL OR c.id = :categoryTag) AND" +
            " (:startTimestamp IS NULL OR a.addDateTime >= :startTimestamp) AND" +
            " (:endTimestamp IS NULL OR a.addDateTime <= :endTimestamp)")
    Page<Advertisement> findAllWithPaging(@Param("titleTag") String titleTag,
                                          @Param("descriptionTag") String descriptionTag,
                                          @Param("categoryTag") Integer categoryTag,
                                          @Param("startTimestamp") Timestamp startTimestamp,
                                          @Param("endTimestamp") Timestamp endTimestamp, Pageable pagable);

    Advertisement findById(int id);
    @Modifying
    <_Advertisement extends Advertisement> _Advertisement save(_Advertisement advertisement);
    @Modifying
    void deleteById(int id);
}
