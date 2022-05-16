package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {

    private List<Food> foodList = new ArrayList<>();

    @Override
    public boolean store(Food food, double lifeBalance) {
        boolean rsl = false;
        if(sort(lifeBalance)) {
            foodList.add(food);
            rsl = true;
        }
        return rsl;
    }

    public List<Food> getFoodList() {
        return foodList;
    }


    public boolean sort(double lifeBalance) {
        return lifeBalance > 75;
    }
}
