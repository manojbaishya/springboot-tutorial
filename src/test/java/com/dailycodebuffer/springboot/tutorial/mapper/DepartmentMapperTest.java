package com.dailycodebuffer.springboot.tutorial.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.dailycodebuffer.springboot.tutorial.dto.DepartmentDto;
import com.dailycodebuffer.springboot.tutorial.entity.Department;

public class DepartmentMapperTest {
    @Test
    void testDeserialize() {

        String name = "SampleName";
        String address = "SampleAddress";
        String code = "SampleCode";

        var sampleDepartmentDto = new DepartmentDto(name, address, code);

        var sampleDepartmentEntity = DepartmentMapper.INSTANCE.deserialize(sampleDepartmentDto);
        assertThat(sampleDepartmentEntity.getDepartmentName()).isEqualTo(name);
        assertThat(sampleDepartmentEntity.getDepartmentAddress()).isEqualTo(address);
        assertThat(sampleDepartmentEntity.getDepartmentCode()).isEqualTo(code);

    }

    @Test
    void testSerialize() {
        String name = "SampleName";
        String address = "SampleAddress";
        String code = "SampleCode";

        var sampleDepartment = new Department(529051L, name, address, code);

        var sampleDepartmentDto = DepartmentMapper.INSTANCE.serialize(sampleDepartment);
        assertThat(sampleDepartmentDto.departmentName()).isEqualTo(name);
        assertThat(sampleDepartmentDto.departmentAddress()).isEqualTo(address);
        assertThat(sampleDepartmentDto.departmentCode()).isEqualTo(code);

    }
}
