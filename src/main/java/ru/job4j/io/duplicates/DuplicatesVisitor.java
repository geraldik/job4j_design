package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, List<Path>> fileMap = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty =
                new FileProperty(Files.size(file), String.valueOf(file.getFileName()));
        List<Path> paths = new ArrayList<>();
        if (fileMap.containsKey(fileProperty)) {
            fileMap.get(fileProperty).add(file);
        } else {
            paths.add(file);
            fileMap.put(fileProperty, paths);
        }
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getFilePath(DuplicatesVisitor duplicatesVisitor) {
        return duplicatesVisitor.fileMap.values()
                .stream()
                .filter(list -> list.size() > 1)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}