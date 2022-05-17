package ru.job4j.design.lsp.parking;

/**
 * Класс реализует интерфейс, описывающий паркуемые машины для легковых автомобилей
 */
public class PassengerCar implements Car {

    public static final int SIZE = 1;
    @Override
    public int carSize() {
        return SIZE;
    }
}
