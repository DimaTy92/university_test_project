package com.example.demo.entity.repository;

import com.example.demo.entity.Department;
import com.example.demo.entity.Lector;
import com.example.demo.entity.type.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("SELECT s FROM Department s where s.departmentName = :departmentName")
    Optional<Department> getDepartment(@Param("departmentName") String departmentName);

    @Query("select count(s) from Department s join s.lectors lec " +
            "where s.departmentName = :departmentName and lec.degree = :degree")
    Optional<Integer> countLectorsInDepartmentByDegree(@Param("departmentName") String departmentName,
                                                       @Param("degree") Degree degree);

    @Query("SELECT avg(lec.lectorsSalary) FROM Department s join s.lectors lec " +
            "where s.departmentName = :departmentName")
    Optional<Double> departmentAverageSalary(@Param("departmentName") String departmentName);

    @Query("SELECT count(s) from Department s join s.lectors lec " +
            "where s.departmentName = :departmentName")
    Optional<Integer> countOfEmployee(@Param("departmentName") String departmentName);
}
