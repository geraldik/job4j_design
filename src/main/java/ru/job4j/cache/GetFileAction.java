package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class GetFileAction implements UserAction {

    private final Output out;
    private  AbstractCache cache;

    public GetFileAction(Output out) {
        this.out = out;
    }

    private void printFiles(String path, PrintFiles printFiles) {
        try {
            Files.walkFileTree(Path.of(path), printFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String name() {
        return "Select file to read";
    }

    @Override
    public boolean execute(Input input) {
        out.println("=== Select file to read from the cache ===");
        cache = PointAction.getCacheDir();
        if (Objects.isNull(cache)) {
            System.out.println("First you need to specify the path to the directory");
        } else {
            printFiles(((DirFileCache) cache).getCachingDir(), new PrintFiles());
            String name = input.askStr("Enter name of file: ");
            if (!Objects.isNull(cache.get(name))) {
                System.out.println(cache.get(name));
            }
        }
        return true;
    }
}
