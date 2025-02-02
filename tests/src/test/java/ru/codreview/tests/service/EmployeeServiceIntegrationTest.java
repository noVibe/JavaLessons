package ru.codreview.tests.service;

import jakarta.transaction.Transactional;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import ru.codreview.tests.AbstractIntegrationTest;
import ru.codreview.tests.dto.CreateRequestDto;
import ru.codreview.tests.dto.EmployeeDto;
import ru.codreview.tests.mapper.EmployeeMapper;
import ru.codreview.tests.repository.EmployeeRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;


public class EmployeeServiceIntegrationTest extends AbstractIntegrationTest {

    @MockitoSpyBean
    EmployeeMapper employeeMapper;

    @MockitoSpyBean
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService service;

    @Disabled("Сломан")
    @DisplayName("Создание Employee и сохранение в БД")
    @Test
    @Transactional
    @Order(1)
    void create() {
        //given
        CreateRequestDto requestDto = new CreateRequestDto("integration", "test");
        String expectedName = "integration test1";

        //when
        EmployeeDto actual = service.create(requestDto);


        //then
        verify(employeeRepository).save(any());
        verify(employeeMapper).fromDto(requestDto);
        verify(employeeMapper).toDto(any());

        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(new EmployeeDto(null, "").id())
                .as("Must have Id")
                .isNotNull()
                .as("Id must be positive")
                .isPositive();
        soft.assertThat(actual.name()).isEqualTo(expectedName);
        soft.assertAll();
    }

    @DisplayName("В БД откатилось создание записи")
    @Test
    @Order(2)
    void assertRepositoryNotAffected() {
        int actual = employeeRepository.findAll().size();
        assertThat(actual).isEqualTo(5);
    }

}
