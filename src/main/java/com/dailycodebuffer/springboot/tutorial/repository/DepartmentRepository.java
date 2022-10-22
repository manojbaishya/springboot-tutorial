package com.dailycodebuffer.springboot.tutorial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.springboot.tutorial.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Optional<Department> findByDepartmentName(String departmentName);

    public Optional<Department> findByDepartmentNameIgnoreCase(String departmentName);
}
