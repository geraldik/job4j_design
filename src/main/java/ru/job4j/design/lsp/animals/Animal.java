package ru.job4j.design.lsp.animals;

public class Animal {

    private double weight;

    public double computeWeightGain(double prey) {
        double gain = 0;
        if (prey >= 0.1 * weight) {
            gain = 0.1 * prey;
        }
        return gain;
    }

}
