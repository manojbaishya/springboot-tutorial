package com.dailycodebuffer.springboot.tutorial.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dailycodebuffer.springboot.tutorial.dto.DepartmentDto;
import com.dailycodebuffer.springboot.tutorial.entity.Department;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    @Mapping(target = "departmentId", ignore = true)
    Department deserialize(DepartmentDto dto);

    @InheritInverseConfiguration
    DepartmentDto serialize(Department entity);
}
