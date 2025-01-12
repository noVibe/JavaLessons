package lombok.super_builder;

import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
public class Man {
    int age;
    String name;
    String sex;
    boolean isDead;
    LocalDate birthDate;
}
