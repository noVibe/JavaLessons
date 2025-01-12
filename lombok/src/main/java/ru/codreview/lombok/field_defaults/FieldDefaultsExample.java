package ru.codreview.lombok.field_defaults;

import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.experimental.PackagePrivate;

import java.lang.reflect.Modifier;
import java.util.function.IntPredicate;

import static org.assertj.core.api.Assertions.assertThat;

//меняем модификаторы полей
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FieldDefaultsExample {
    String one;
    @PackagePrivate
    int two;


    public static void main(String[] args) {
        IntPredicate isPackagePrivate =
                ((IntPredicate) Modifier::isPrivate)
                        .or(Modifier::isProtected)
                        .or(Modifier::isPublic)
                        .negate();

        assertThat(FieldDefaultsExample.class)
                .hasOnlyDeclaredFields("one", "two")
                .matches(aClass -> checkFieldModifier(aClass, "one", Modifier::isPrivate))
                .matches(aClass -> checkFieldModifier(aClass, "two", isPackagePrivate));

    }
    @SneakyThrows
    static boolean checkFieldModifier(Class<?> clazz, String field, IntPredicate predicate) {
        return predicate.test(clazz.getDeclaredField(field).getModifiers());
    }

}
