package ru.codreview.tests.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;
import ru.codreview.tests.dto.EmployeeDto;
import ru.codreview.tests.entity.Employee;
import ru.codreview.tests.mapper.EmployeeMapper;
import ru.codreview.tests.repository.EmployeeRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceUnitTest {

    @Mock
    EmployeeRepository repository;
    @Mock
    EmployeeMapper mapper;

    @InjectMocks
    EmployeeService service;

    @DisplayName("Успешное создание Employee")
    @Test
    void findSuccess() {
        //given
        Employee employee = new Employee();
        EmployeeDto expected = new EmployeeDto(1L, "Bob");

        //when
        when(repository.findById(any())).thenReturn(Optional.of(employee));
        when(mapper.toDto(employee)).thenReturn(expected);

        EmployeeDto actual = service.find(1L);

        //then
        assertThat(actual).isEqualTo(expected);
        verify(repository).findById(any());
        verify(mapper).toDto(employee);
    }

    @DisplayName("Кидаем Not Found, когда не найден Employee")
    @Test
    void findFail() {
        //given //when
        when(repository.findById(any())).thenReturn(Optional.empty());

        //then
        assertThatExceptionOfType(ResponseStatusException.class)
                .isThrownBy(() -> service.find(any()));
    }

}