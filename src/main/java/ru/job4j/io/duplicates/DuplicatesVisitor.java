package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, Path> fileMap = new HashMap<>();
    private final List<Path> paths = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(Files.size(file), String.valueOf(file.getFileName()));
        Path tempPath = fileMap.computeIfPresent(fileProperty, (k, v) -> v);
        if (tempPath != null) {
            paths.add(tempPath);
            paths.add(file);
        }
        fileMap.put(fileProperty, file);
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getPaths() {
        return paths;
    }
}