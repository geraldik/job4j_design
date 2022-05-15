package ru.job4j.design.icp.fish;

/**
 * Данный интерфейс описывает абстрактную рыбу.
 * Класс FlyFish реализует все методы представленные интерфейсом.
 * Класс Shark не может реализовать метод fly(), так как акулы не умеют летать.
 */
public interface Fish {

    void eat();

    void hide();

    void fly();
}
