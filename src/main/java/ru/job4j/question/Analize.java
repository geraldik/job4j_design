package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, String> previousMap = new HashMap<>();
        Map<Integer, String> currentMap = new HashMap<>();
        int addCount = 0;
        int changeCount = 0;
        int deleteCount = 0;
        for (User user : previous) {
            previousMap.put(user.getId(), user.getName());
        }
        for (User user : current) {
            currentMap.put(user.getId(), user.getName());
        }
        for (User user : current) {
            if (previousMap.get(user.getId()) == null) {
                addCount++;
            } else if (!previousMap.get(user.getId()).equals(user.getName())) {
                changeCount++;
            }
        }
        for (User user : previous) {
            if (currentMap.get(user.getId()) == null) {
                deleteCount++;
            }
        }
        return new Info(addCount, changeCount, deleteCount);
    }
}