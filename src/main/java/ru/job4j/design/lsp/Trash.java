package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {

    private List<Food> foodList = new ArrayList<>();

    public void store(Food food) {
        foodList.add(food);
    }

    @Override
    public void sort(Food food, double lifeBalance) {
        if (lifeBalance <= 0) {
            store(food);
        }
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}