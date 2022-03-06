package ru.job4j.serialization.json;

import java.util.Arrays;

public class Car {
    private String name;
    private boolean fourWheelDrive;
    private int engine;
    private Size size;
    private String[] comfort;

    public Car(String name, boolean fourWheelDrive, int engine, Size size, String[] comfort) {
        this.name = name;
        this.fourWheelDrive = fourWheelDrive;
        this.engine = engine;
        this.size = size;
        this.comfort = comfort;
    }

    @Override
    public String toString() {
        return "Car{"
                + "name='" + name + '\''
                + ", fourWheelDrive=" + fourWheelDrive
                + ", engine=" + engine
                + ", size=" + size
                + ", comfort=" + Arrays.toString(comfort)
                + '}';
    }
}
