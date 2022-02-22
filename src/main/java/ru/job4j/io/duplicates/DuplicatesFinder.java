package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        List<Path> paths;
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./"), duplicatesVisitor);
        paths = duplicatesVisitor.getPaths();
        paths.forEach(path -> System.out.println(path.toAbsolutePath()));
    }
}