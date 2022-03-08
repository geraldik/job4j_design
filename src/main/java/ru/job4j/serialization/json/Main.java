package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Car car = new Car("Niva Lada", true, 1700,
                new Size(4099, 1652, 1804),
                new String[]{"conditioner", "seats heater", "multimedia"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));
        System.out.println("______________________________");
        final Car sameCar = gson.fromJson(gson.toJson(car), Car.class);
        System.out.println(sameCar);
        System.out.println("______________________________");

        JSONObject jsonSize = new JSONObject("{\"length\":\"4096\", \"height\":\"4096\", \"width\":\"4096\"}");

        List<String> list = new ArrayList<>();
        list.add("conditioner");
        list.add("seats heater");
        list.add("multimedia");
        JSONArray jsonComfort = new JSONArray(list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", car.getName());
        jsonObject.put("fourWheelDrive", car.isFourWheelDrive());
        jsonObject.put("engine", car.getEngine());
        jsonObject.put("size", jsonSize);
        jsonObject.put("comfort", jsonComfort);

        System.out.println(jsonObject);
        System.out.println("______________________________");
        System.out.println(new JSONObject(car));
    }
}