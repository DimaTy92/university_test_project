package com.example.demo.entity.repository;

import com.example.demo.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query("SELECT s from Lector s where lower(s.firstName) LIKE CONCAT('%', :pattern, '%') or lower(s.lastName) LIKE CONCAT('%', :pattern, '%')")
    List<Lector> globalSearchByPattern(@Param("pattern") String pattern);
}
