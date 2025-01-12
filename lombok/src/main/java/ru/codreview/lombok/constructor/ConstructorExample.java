package ru.codreview.lombok.constructor;

import lombok.AllArgsConstructor;

import java.lang.annotation.Annotation;

import static org.assertj.core.api.Assertions.assertThat;
//добавляем к конструктору дополнительные аннотации
@AllArgsConstructor(onConstructor_ = {
        @DummyAnnotation,
        @DummyParameterAnnotation("param"),
})
public class ConstructorExample {
    String str;

    public static void main(String[] args) {

        Annotation[] annotations = ConstructorExample.class
                .getDeclaredConstructors()[0]
                .getDeclaredAnnotations();

        assertThat(annotations).hasSize(2);

        assertThat(annotations[0]).isNotNull()
                .isInstanceOf(DummyAnnotation.class);

        assertThat(annotations[1]).isNotNull()
                .isInstanceOf(DummyParameterAnnotation.class)
                .extracting(DummyParameterAnnotation.class::cast)
                .extracting(DummyParameterAnnotation::value)
                .isEqualTo("param");
    }
}
