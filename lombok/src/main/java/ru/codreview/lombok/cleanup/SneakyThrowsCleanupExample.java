package ru.codreview.lombok.cleanup;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class SneakyThrowsCleanupExample {


    //"обманываем" компилятор, чтобы не оборачивать в try-catch данные проверяемые исключения
    @SneakyThrows({URISyntaxException.class, IOException.class})
    public static void main(String[] args) {
        URL resource = SneakyThrowsCleanupExample.class
                .getClassLoader()
                .getResource("example.txt");
        URI uri = Objects.requireNonNull(resource).toURI();
        //автоматически заворачиваем AutoClosable в try-with-resources
        @Cleanup Stream<String> lines = Files.lines(Paths.get(uri));
        lines.forEach(System.out::println);
    }

}
