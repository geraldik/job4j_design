package ru.job4j.design.lsp.parking;

/**
 * Интерфейс описывающий сервис учета парковки машин
 */
public interface Parking {
    int park(Car car);
}
