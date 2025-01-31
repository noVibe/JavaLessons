package ru.codreview.tests.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.codreview.tests.dto.EmployeeDto;
import ru.codreview.tests.service.EmployeeService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockitoBean
    EmployeeService service;

    @DisplayName("200 Ok получение EmployeeDto")
    @Test
    @SneakyThrows
    void getEmployeeOk() {
        //given
        EmployeeDto dto = new EmployeeDto(1L, "Bob");

        //when //then
        Mockito.when(service.find(1L)).thenReturn(dto);

        mockMvc.perform(get("/employee/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Bob"));
    }
    @DisplayName("400 Bad Request для Id < 1")
    @Test
    @SneakyThrows
    void getEmployeeBadRequest() {
        mockMvc.perform(get("/employee/-1"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Validation failed: getById.id: must be greater than 0"));
    }

}