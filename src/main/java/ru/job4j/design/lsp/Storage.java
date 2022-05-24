package ru.job4j.design.lsp;

import java.util.List;

public interface Storage {

    boolean store(Food food, double lifeBalance);

    boolean sort(double lifeBalance);

    List<Food> getFoodList();

    void clear();

}
