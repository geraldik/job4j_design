package ru.job4j.srp;

public class Calculator {

    public static double sum(double a, double b) {
        return a + b;
    }

    public static double dif(double a, double b) {
        return a - b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }

    public static double div(double a, double b) {
        return a / b;
    }

    public static void printAll(double a, double b) {
        System.out.println("Сумма двух чисел: " + sum(a, b));
        System.out.println("Разница двух чисел: " + dif(a, b));
        System.out.println("Умножение двух чисел: " + multiplication(a, b));
        System.out.println("Деление двух чисел: " + dif(a, b));
    }
}
