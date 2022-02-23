package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.function.Predicate;


public class Search {
    private static void inputValidating(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Search folder is null or file extension is not set. Usage java -jar Search.jar"
                    + " SEARCH_FOLDER SEARCH_FILE_EXTENSION.");
        }
        if (!Files.exists(Paths.get(args[0]))
                || !Files.isDirectory(Paths.get(args[0]))) {
            throw new IllegalArgumentException("Path does not exist or does not point to a directory.");
        }
    }

    public static void main(String[] args) throws IOException {
        inputValidating(args);
        Path start = Paths.get(args[0]);
        search(start, p -> p.toFile().getName().endsWith("." + args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}