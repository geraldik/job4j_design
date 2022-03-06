package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class    Main {
    public static void main(String[] args) {
        final Car car = new Car("Niva Lada", true, 1700,
                new Size(4099, 1652, 1804),
                new String[] {"conditioner", "seats heater", "multimedia"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));
        final Car sameCar = gson.fromJson(gson.toJson(car), Car.class);
        System.out.println(sameCar);
    }
}