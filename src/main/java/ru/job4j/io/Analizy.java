package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> stringList;
        List<String> tempList = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            stringList = read.lines().collect(Collectors.toList());
            for (int i = 0; i < stringList.size(); i++) {
                boolean currentState = isDown(stringList.get(i));
                boolean beforeState = i != 0 && isDown(stringList.get(i - 1));
                if (currentState != beforeState) {
                    tempList.add(stringList.get(i).split(" ")[1]);
                }
            }
            for (int i = 0, j = 1; j < tempList.size(); i = i + 2, j = j + 2) {
                out.printf(String.format("%s%s%s%n", tempList.get(i), ";", tempList.get(j)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isDown(String line) {
        return line.startsWith("400")
                || line.startsWith("500");
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("server.log", "unavailable.log");
    }
}