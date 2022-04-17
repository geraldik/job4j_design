package ru.job4j.cache;

import java.io.*;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader read = new BufferedReader(new FileReader(cachingDir + File.separator + key))) {
            String line;
            while ((line = read.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}