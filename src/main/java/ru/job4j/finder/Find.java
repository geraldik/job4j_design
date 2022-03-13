package ru.job4j.finder;

import ru.job4j.io.ArgsName;
import ru.job4j.io.Search;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class Find {
    private final ArgsName jvm;

    public Find(String[] args) {
        this.jvm = ArgsName.of(args);
    }

    private Predicate<Path> searchCriteria(String name, String type) {
        String finalName = "mask".equals(type) ? createRegex(name) : name;
        return p -> p.toFile().getName().matches(finalName);
    }

    public void searching() {
        try (PrintWriter printWriter = new PrintWriter(jvm.get("o"))) {
            List<Path> pathList = Search.search(Path.of(jvm.get("d")),
                    searchCriteria(jvm.get("n"), jvm.get("t")));
            pathList.forEach(path -> printWriter.printf("%s%n", path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void inputValidating() {
        if (jvm.size() != 4) {
            throw new IllegalArgumentException("Wrong amount of arguments. Use java -jar find.jar"
                    + " -d=SEARCHING_PATH -n=NAME -t=SEARCHING_CRITERIA -o=OUTPUT_PATH");
        }
        if (jvm.get("d") == null
                || jvm.get("n") == null
                || jvm.get("t") == null
                || jvm.get("o") == null) {
            throw new IllegalArgumentException("Wrong set of keys. Use java -jar find.jar"
                    + " -d=SEARCHING_PATH -n=NAME -t=SEARCHING_CRITERIA -o=OUTPUT_PATH");
        }
        if (!Files.isDirectory(Path.of(jvm.get("d")))) {
            throw new IllegalArgumentException("Wrong path to searching directory.");
        }
    }

    private String createRegex(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                sb.append(".+");
            } else if (ch == '?') {
                sb.append(".");
            } else if (ch == '.') {
                sb.append("\\.");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Find find = new Find(args);
        find.inputValidating();
        find.searching();
    }
}
