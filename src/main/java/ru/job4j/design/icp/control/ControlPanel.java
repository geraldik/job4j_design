package ru.job4j.design.icp.control;

/**
 * Интерфейс ControlPanel описывает абстрактный пульт управления.
 * Реализация ControlTV реализует все представленные интерфейсом методы.
 * Реализация ControlSoundSystem реализует не все представленные интерфейсом методы:
 * метод selectChannel не может быть реализован в данном пульте управления.
 */
public interface ControlPanel {

    void power();

    void volumeUp(int unit);

    void volumeDown(int unit);

    void menu();

    void selectChannel();

}
