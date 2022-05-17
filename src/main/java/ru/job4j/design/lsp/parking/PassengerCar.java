package ru.job4j.design.lsp.parking;

/**
 * Класс реализует интерфейс, описывающий паркуемые машины для легковых автомобилей
 */
public class PassengerCar implements Car {

    @Override
    public int carSize() {
        return 1;
    }
}
