package ru.job4j.design.dip;

import java.time.LocalDate;

/**
 * Класс Person зависит от конкретного класса Cat, а не от абстракции. Следует создать интерфейс Pet, который будет
 * наследовать класс Cat и связать класс Person c созданным интерфейсом.
 */
public class Person {

    private final String name;

    private final LocalDate birthday;

    private Cat cat;

    public Person(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Cat getCat() {
        return cat;
    }
}
