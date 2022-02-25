package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private List<String> phrases;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
        pathValidating();
    }

    public void run() {
        List<String> log = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in))) {
                boolean flag = true;
                boolean mute = false;
                System.out.println("Начните чат:");
                while (flag) {
                    String inLine = reader.readLine();
                    log.add(inLine);
                    switch (inLine) {
                        case OUT:
                            flag = false;
                            break;
                        case STOP:
                            mute = true;
                            break;
                        case CONTINUE:
                            mute = false;
                        default:
                            if (!mute) {
                                String answer = randomString(readPhrases());
                                System.out.printf("%s%s%n", "bot: ", answer);
                                log.add(answer);
                            }
                            break;
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveLog(log);
    }

    private List<String> readPhrases() {
        try (BufferedReader read = new BufferedReader(new FileReader(botAnswers))) {
            phrases = read.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String randomString(List<String> phrases) {
        Random r = new Random();
        return phrases.get(r.nextInt(phrases.size()));
    }

    private void pathValidating() {
        if (Files.isDirectory(Path.of(path))) {
            throw new IllegalArgumentException("Path to the log file is point to a directory.");
        }
        if (Files.isDirectory(Path.of(botAnswers))) {
            throw new IllegalArgumentException("Path to the answers file is point to a directory.");
        }
        if (!Files.exists(Path.of(botAnswers))) {
            throw new IllegalArgumentException("The answers file not found at specified path.");
        }
        if (readPhrases().size() == 0) {
            throw new IllegalArgumentException("The answers file is empty.");
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("C:\\project\\job4j_design\\log.txt", "C:\\project\\job4j_design\\answers.txt");
        cc.run();
    }
}