package ru.codreview.lombok.super_builder;

import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder //даем возможность "протянуть" билдер в наследника
public class Man {
    int age;
    String name;
    String sex;
    boolean isDead;
    LocalDate birthDate;
}
