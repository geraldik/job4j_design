package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        OutputStream outputStream = "stdout".equals(argsName.get("out"))
                ? System.out : new FileOutputStream(argsName.get("out"));
        try (BufferedReader read = new BufferedReader(new FileReader(argsName.get("path")));
             PrintWriter out = new PrintWriter(outputStream)) {
            String line = read.readLine();
            String delimiter = argsName.get("delimiter");
            String[] columnName = line.split(delimiter);
            String[] filterName = argsName.get("filter").split(",");
            int[] indexes = rightIndex(columnName, filterName);
            for (int i = 0, j = 0; i < indexes.length; i++) {
                filterName[j++] = columnName[indexes[i]];
            }
            out.println(String.join(delimiter, filterName));
            while ((line = read.readLine()) != null) {
                var scanner = new Scanner(line)
                        .useDelimiter(argsName.get("delimiter"));
                var count = 0;
                List<String> temp = new ArrayList<>();
                while (scanner.hasNext()) {
                    if (filtering(indexes, count)) {
                        temp.add(scanner.next());
                    } else {
                        scanner.next();
                    }
                    count++;
                }
                out.print(String.join(delimiter, temp));
                out.println();
            }

        }
    }

    private static int[] rightIndex(String[] columnName, String[] filter) {
        int[] indexes = new int[filter.length];
        for (int i = 0, k = 0; i < columnName.length; i++) {
            for (String s : filter) {
                if (columnName[i].equals(s)) {
                    indexes[k++] = i;
                }
            }
        }

        return indexes;
    }

    private static boolean filtering(int[] indexes, int count) {
        boolean rsl = false;
        for (int index : indexes) {
            if (index == count) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    private static void inputValidating(ArgsName argsName) {
        if (argsName.get("path") == null) {
            throw new IllegalArgumentException("There is no the path argument.");
        }
        if (argsName.get("delimiter") == null) {
            throw new IllegalArgumentException("There is no the delimiter argument.");
        }
        if (argsName.get("out") == null) {
            throw new IllegalArgumentException("There is no the out argument.");
        }
        if (argsName.get("filter") == null) {
            throw new IllegalArgumentException("There is no the filter argument.");
        }
        if (!Files.exists(Path.of(argsName.get("path")))) {
            throw new IllegalArgumentException("File does not exist.");
        }
    }

    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        inputValidating(argsName);
        handle(argsName);
    }
}