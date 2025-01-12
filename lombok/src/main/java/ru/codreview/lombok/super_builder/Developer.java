package ru.codreview.lombok.super_builder;

import lombok.experimental.SuperBuilder;

import java.util.Set;
@SuperBuilder //"протягиваем" билдер из предка
public class Developer extends Man {
    Set<String> skills;
}
