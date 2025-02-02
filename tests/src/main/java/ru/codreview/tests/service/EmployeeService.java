package ru.codreview.tests.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.codreview.tests.dto.CreateRequestDto;
import ru.codreview.tests.entity.Employee;
import ru.codreview.tests.dto.EmployeeDto;
import ru.codreview.tests.mapper.EmployeeMapper;
import ru.codreview.tests.repository.EmployeeRepository;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeDto find(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "No employee with id " + id));
        return employeeMapper.toDto(employee);
    }

    public EmployeeDto create(CreateRequestDto createRequestDto) {
        Employee employee = employeeMapper.fromDto(createRequestDto);
        employeeRepository.save(employee);
        return employeeMapper.toDto(employee);
    }

    public List<EmployeeDto> findAll() {
        return employeeMapper.toDtos(employeeRepository.findAll());
    }

}
