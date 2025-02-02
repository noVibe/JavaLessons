package ru.codreview.tests.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateRequestDto(@NotBlank String firstName, @NotBlank String lastName) {
}
