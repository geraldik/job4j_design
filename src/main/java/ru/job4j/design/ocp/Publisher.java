package ru.job4j.design.ocp;

import java.util.ArrayList;
import java.util.List;

/**
 * В данном классе в качестве типизации абстрактного поля указан конкретный класс, а не абстракция.
 * Метод find() возвращает не абстракцию, а конкретную реализацию List. Так же в качестве входных данных
 * не абстракция, а конкретный класс (лучше использовать функциональный интерфейс)
 */

public class Publisher {

    private List<Comics> comics;


    public Publisher(List<Comics> comics) {
        this.comics = comics;
    }

    public ArrayList<Comics> find(String string) {
        return null;
    }
}
