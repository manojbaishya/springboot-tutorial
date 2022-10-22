package com.dailycodebuffer.springboot.tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.exception.ResourceNotFoundException;
import com.dailycodebuffer.springboot.tutorial.repository.DepartmentRepository;
import com.dailycodebuffer.springboot.tutorial.utility.StringUtilities;

@Service
public class DepartmentServiceImplementation implements DepartmentService {

    private static final String ERROR_MESSAGE = "Department does not exist for this id: %s";

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(final Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(final Long departmentId) throws ResourceNotFoundException {
        return this.departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException(
                        ERROR_MESSAGE.formatted(departmentId)));
    }

    @Override
    public Department updateDepartment(final Long departmentId,
            final Department department) throws ResourceNotFoundException {
        final Department currentDepartment = this.departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException(
                        ERROR_MESSAGE.formatted(departmentId)));

        if (!StringUtilities.isNullOrEmpty(department.getDepartmentName())) {
            currentDepartment.setDepartmentName(department.getDepartmentName());
        }

        if (!StringUtilities.isNullOrEmpty(department.getDepartmentAddress())) {
            currentDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (!StringUtilities.isNullOrEmpty(department.getDepartmentCode())) {
            currentDepartment.setDepartmentCode(department.getDepartmentCode());
        }

        return this.departmentRepository.save(currentDepartment);
    }

    @Override
    public boolean deleteDepartmentById(final Long departmentId) throws ResourceNotFoundException {
        final Department department = this.departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException(
                        ERROR_MESSAGE.formatted(departmentId)));
        try {
            this.departmentRepository.delete(department);
            return true;
        } catch (final Exception ex) {
            return false;
        }
    }

    @Override
    public Department fetchDepartmentByName(final String departmentName) throws ResourceNotFoundException {
        return this.departmentRepository.findByDepartmentNameIgnoreCase(departmentName)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Department with name %s not found!", departmentName)));
    }

}
