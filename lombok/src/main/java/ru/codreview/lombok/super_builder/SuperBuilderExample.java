package ru.codreview.lombok.super_builder;

import java.util.Set;

public class SuperBuilderExample {
    public static void main(String[] args) {
        Developer.builder()
                .age(30)
                .name("Biba")
                .sex("male")
                .skills(Set.of("Lombok :)"))
                .isDead(true);

    }
}
