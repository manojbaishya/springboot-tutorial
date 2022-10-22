package com.dailycodebuffer.springboot.tutorial.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.exception.ResourceNotFoundException;
import com.dailycodebuffer.springboot.tutorial.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setupRequirements() {
        department = Department
                .builder(98765L)
                .departmentName("TestControllerDepartment")
                .departmentAddress("TestControllerDepartmentAddress")
                .departmentCode("TCD001")
                .build();
    }

    @Test
    void testSaveDepartment() throws Exception {
        var inputDepartment = Department
                .builder(null)
                .departmentName("TestControllerDepartment")
                .departmentAddress("TestControllerDepartmentAddress")
                .departmentCode("TCD001")
                .build();

        Mockito
            .when(departmentService.saveDepartment(inputDepartment))
            .thenReturn(department);

        mockMvc.perform(
                post("/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    """
                    {
                        "departmentName": "TestControllerDepartment",
                        "departmentAddress": "TestControllerDepartmentAddress",
                        "departmentCode": "TCD001"
                    }
                    """
                )
            )
            .andExpect(status().isOk());
    }

    @Test
    void testGetDepartmentById() throws Exception, ResourceNotFoundException {
        Mockito
        .when(departmentService.fetchDepartmentById(98765L))
        .thenReturn(department);

        mockMvc.perform(
                get("/department?id={departmentId}", 98765L)
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andExpect(
                jsonPath("$.departmentName")
                .value(department.getDepartmentName())
            );
    }
}
