package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private ArgsName jvm;

    public void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(String.valueOf(target))))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(String.valueOf(path)));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(String.valueOf(path)))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void inputValidating(String[] args) {
        jvm = ArgsName.of(args);
        if (jvm.get("d") == null
                || jvm.get("e") == null
                || jvm.get("o") == null) {
            throw new IllegalArgumentException("Required argument is missing.");
        }
        if (!Files.exists(Path.of(jvm.get("d")))) {
            throw new IllegalArgumentException("The zipping directory is not exist.");
        }
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.inputValidating(args);
        List<Path> sources = Search.search(Path.of(zip.jvm.get("d")),
                p -> !p.toFile().getName().endsWith(zip.jvm.get("e")));
        zip.packFiles(sources, Path.of(zip.jvm.get("o")));
    }
}