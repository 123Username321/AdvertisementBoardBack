package ru.plotnikov.advboard.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.plotnikov.advboard.model.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM Category c WHERE (:categoryTag IS NULL OR c.id = :categoryTag)")
    List<Category> findAll(@Param("categoryTag") Integer categoryTag, Sort sort);

    @Query("SELECT c FROM Category c WHERE (:categoryTag IS NULL OR c.id = :categoryTag)")
    List<Category> findAllWithPaging(@Param("categoryTag") Integer categoryTag, Pageable pageable);

    Category findById(int id);
    @Modifying
    <_Category extends Category> _Category save(_Category category);
    @Modifying
    void deleteById(int id);
}
