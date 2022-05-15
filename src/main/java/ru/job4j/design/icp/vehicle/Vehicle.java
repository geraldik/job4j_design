package ru.job4j.design.icp.vehicle;

/**
 * Данный интерфейс описывает абстрактное транспортное средство.
 * Класс Car реализует все методы представленные интерфейсом.
 * Класс Subway не может реализовать метод pumpUb (подкачка колеса).
 */
public interface Vehicle {

    int getPassengerSits();

    void startEngine();

    void move();

    void pumpUb();
}
