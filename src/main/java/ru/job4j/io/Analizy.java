package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {

        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            List<String> tempList = new ArrayList<>();
            String line;
            boolean beforeState = false;
            while ((line = read.readLine()) != null) {
                boolean currentState = isDown(line);
                if (currentState != beforeState) {
                    beforeState = currentState;
                    tempList.add(line.split(" ")[1]);
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