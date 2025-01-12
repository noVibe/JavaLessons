package ru.codreview.lombok.accessors;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
//setter возвращает this вместо void; getter и setter теперь без префиксов
@Accessors(fluent = true)
public class AccessorsExample {

    String stringField;
    int intField;

    public static void main(String[] args) {
        AccessorsExample example = new AccessorsExample();
        example.intField(1)
                .stringField("s");

    }
}
