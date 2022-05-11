package ru.job4j.design.lsp.birds;

/**
 * Данный класс не реализует метод fly, так как пингвины летать не умеют. Это нарушает LSP.
 */

public class Penguin extends Bird {

    @Override
    public void fly() {
        try {
            throw new Exception("The method is not implemented");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eat() {
        System.out.println("The penguin is eat");
    }

    @Override
    public void sleep() {
        System.out.println("The penguin is sleep");
    }
}
