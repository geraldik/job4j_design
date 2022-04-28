package ru.job4j.cache;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    public static boolean validatePath(String path) {
        return (Files.exists(Path.of(path))
            && Files.isDirectory(Path.of(path)));
    }

    @Override
    protected String load(String key) {
        String content = null;
        try {
            content = Files.readString(Path.of(cachingDir, key));
        } catch (IOException e) {
            System.out.println("There is now selected file.");
        }
        return content;
    }

    public String getCachingDir() {
        return cachingDir;
    }
}