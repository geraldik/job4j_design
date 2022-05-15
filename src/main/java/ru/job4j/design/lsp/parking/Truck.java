package ru.job4j.design.lsp.parking;

/**
 * Класс реализует интерфейс, описывающий паркуемые машины для грузовых автомобилей
 */
public class Truck implements Car {
    @Override
    public int carSize() {
        return 0;
    }
}
