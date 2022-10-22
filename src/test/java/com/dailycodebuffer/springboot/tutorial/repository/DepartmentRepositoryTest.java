package com.dailycodebuffer.springboot.tutorial.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.dailycodebuffer.springboot.tutorial.entity.Department;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setupRequirements() {
        var department = Department.builder(null)
                .departmentName("Mechanical Engineering")
                .departmentAddress("Tower C Building")
                .departmentCode("ME001")
                .build();

        testEntityManager.persist(department);
    }

    @Test
    void whenFindByIdThenReturnDepartment() {
        var department = departmentRepository.findByDepartmentName("Mechanical Engineering").get();

        assertThat(department.getDepartmentCode()).isEqualTo("ME001");

    }
}
