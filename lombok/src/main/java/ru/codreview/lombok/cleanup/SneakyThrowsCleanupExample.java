package lombok.cleanup;

import lombok.Cleanup;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class SneakyThrowsCleanupExample {


    @SneakyThrows({URISyntaxException.class, IOException.class})
    public static void main(String[] args) {
        URL resource = SneakyThrowsCleanupExample.class
                .getClassLoader()
                .getResource("example.txt");
        URI uri = Objects.requireNonNull(resource).toURI();
        @Cleanup Stream<String> lines = Files.lines(Paths.get(uri));
        lines.forEach(System.out::println);
    }

}
