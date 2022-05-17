package ru.job4j.design.lsp;

public interface Storage {

    boolean store(Food food, double lifeBalance);
    boolean sort(double lifeBalance);
}
