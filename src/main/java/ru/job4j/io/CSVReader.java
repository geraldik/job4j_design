package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        OutputStream outputStream = argsName.get("out").equals("stdout")
                ? System.out : new FileOutputStream(argsName.get("out"));
        try (BufferedReader read = new BufferedReader(new FileReader(argsName.get("path")));
             PrintWriter out = new PrintWriter(outputStream)) {
            String line = read.readLine();
            String delimiter = argsName.get("delimiter");
            String[] columnName = line.split(delimiter);
            String[] filterName = argsName.get("filter").split(",");
            int[] indexes = rightIndex(columnName, filterName);
            out.print(String.join(delimiter, filterName));
            out.println();
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

    private static void inputValidating(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Wrong amount of arguments.");
        }
        if (!args[0].startsWith("path")) {
            throw new IllegalArgumentException("The first argument should be the path.");
        }
        if (!args[1].startsWith("delimiter")) {
            throw new IllegalArgumentException("The second argument should be the delimiter.");
        }
        if (!args[2].startsWith("out")) {
            throw new IllegalArgumentException("The third argument should be the out.");
        }
        if (!args[3].startsWith("filter")) {
            throw new IllegalArgumentException("The fourth argument should be the filter.");
        }
        if (!Files.exists(Paths.get(args[0]))
                || Files.isDirectory(Paths.get(args[0]))) {
            throw new IllegalArgumentException("File does not exist or path does not point to a file.");
        }
    }

    public static void main(String[] args) throws Exception {
        inputValidating(args);
        handle(ArgsName.of(args));
    }
}