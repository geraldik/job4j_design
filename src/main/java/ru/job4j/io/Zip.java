package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

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

    public void packSingleFile(Path source, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(String.valueOf(target))))) {
            zip.putNextEntry(new ZipEntry(String.valueOf(source)));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(String.valueOf(source)))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        ArgsName jvm = ArgsName.of(args);
        if (jvm.get("d") == null
                || jvm.get("e") == null
                || jvm.get("o") == null) {
            throw new IllegalArgumentException(" Required argument is missing.");
        }
        if (!Files.exists(Path.of(jvm.get("d")))) {
            throw new IllegalArgumentException("The zipping directory is not exist.");
        }
        List<Path> sources = Search.search(Path.of(jvm.get("d")),
                p -> !p.toFile().getName().endsWith(jvm.get("e")));
        zip.packFiles(sources, Path.of(jvm.get("o")));
    }
}