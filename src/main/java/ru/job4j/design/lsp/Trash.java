package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {

    private List<Food> foodList = new ArrayList<>();

    public boolean store(Food food, double lifeBalance) {
        boolean rsl = false;
        if (sort(lifeBalance)) {
            foodList.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean sort(double lifeBalance) {
        return lifeBalance < 0;
    }

    public List<Food> getFoodList() {
        return new ArrayList<>(foodList);
    }
}