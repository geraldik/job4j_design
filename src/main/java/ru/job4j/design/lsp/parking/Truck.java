package ru.job4j.design.lsp.parking;

/**
 * Класс реализует интерфейс, описывающий паркуемые машины для грузовых автомобилей
 */
public class Truck implements Car {

    private int size;

    public Truck(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("The size of truck couldn't be less than 2.");
        }
        this.size = size;
    }

    @Override
    public int carSize() {
        return size;
    }
}
