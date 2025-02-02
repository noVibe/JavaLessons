package ru.codreview.tests.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import ru.codreview.tests.dto.CreateRequestDto;
import ru.codreview.tests.entity.Employee;
import ru.codreview.tests.dto.EmployeeDto;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
@Component
public interface EmployeeMapper {

    @Mapping(target = "name", expression = "java(employee.getFirstName() + \" \" + employee.getLastName())")
    EmployeeDto toDto(Employee employee);

    Employee fromDto(CreateRequestDto createRequestDto);

    List<EmployeeDto> toDtos(List<Employee> employees);

}
