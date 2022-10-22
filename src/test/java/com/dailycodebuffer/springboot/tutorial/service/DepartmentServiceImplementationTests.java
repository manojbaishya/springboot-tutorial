package com.dailycodebuffer.springboot.tutorial.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.exception.ResourceNotFoundException;
import com.dailycodebuffer.springboot.tutorial.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceImplementationTests {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setupRequirements() {
        var department = Department
                .builder(96378541L)
                .departmentName("SampleDepartmentName")
                .departmentAddress("SampleDepartmentAddress")
                .departmentCode("XC32B")
                .build();
        Mockito
            .when(departmentRepository.findByDepartmentNameIgnoreCase("SampleDepartmentName"))
            .thenReturn(Optional.of(department));
    }

    @Test
    @DisplayName("Get department by name.")
    void whenValidDepartmentNameIsGivenThenDepartmentShouldBeFound() throws ResourceNotFoundException {
        String departmentName = "SampleDepartmentName";
        Department foundDepartment = departmentService.fetchDepartmentByName(departmentName);

        assertThat(foundDepartment).isNotNull();
        assertThat(foundDepartment.getDepartmentName()).isEqualTo(departmentName);
    }
}
