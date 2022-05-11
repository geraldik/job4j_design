package ru.job4j.design.lsp.animals;

/**
 * Переопределенный метод computeWeightGain в наследнике класса Animal ослабляет постусловие. Это нарушает LSP.
 */
public class Lion extends Animal {

    @Override
    public double computeWeightGain(double prey) {
        return prey * 0.1;
    }
}
