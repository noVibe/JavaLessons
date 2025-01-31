package ru.codreview.tests.controller;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.codreview.tests.dto.CreateRequestDto;
import ru.codreview.tests.dto.EmployeeDto;
import ru.codreview.tests.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@Validated
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public EmployeeDto getById(@Positive @PathVariable("id") Long id) {
        return employeeService.find(id);
    }

    @PostMapping
    public EmployeeDto create(@Validated @RequestBody CreateRequestDto createRequestDto) {
        return employeeService.create(createRequestDto);
    }

    @GetMapping
    public List<EmployeeDto> getAll() {
        return employeeService.findAll();
    }

}
