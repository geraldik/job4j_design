package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.function.Predicate;


public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Search folder is null. Usage java -jar Search.jar"
                   + " SEARCH_FOLDER SEARCH_FILE_EXTENSION.");
        }
        if (args.length == 1) {
            throw new IllegalArgumentException("File extension is not set. Usage java -jar Search.jar"
                    + " SEARCH_FOLDER SEARCH_FILE_EXTENSION.");
        }

        Path start = Paths.get(args[0]);
        search(start, p -> p.toFile().getName().endsWith("." + args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}