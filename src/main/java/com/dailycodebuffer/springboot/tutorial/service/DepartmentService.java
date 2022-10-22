package com.dailycodebuffer.springboot.tutorial.service;

import java.util.List;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.exception.ResourceNotFoundException;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> fetchDepartments();

    Department fetchDepartmentById(Long departmentId) throws ResourceNotFoundException;

    Department updateDepartment(Long departmentId,
            Department department) throws ResourceNotFoundException;

    boolean deleteDepartmentById(Long departmentId) throws ResourceNotFoundException;

    Department fetchDepartmentByName(String departmentName) throws ResourceNotFoundException;

}
