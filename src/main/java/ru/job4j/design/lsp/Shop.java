package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {

    private List<Food> foodList = new ArrayList<>();

    public void store(Food food) {
        foodList.add(food);
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    @Override
    public void sort(Food food, double lifeBalance) {
        if (lifeBalance >= 25 && lifeBalance <= 75) {
            store(food);
        } else if (lifeBalance < 25 && lifeBalance >= 0) {
            store(food);
            food.setPrice(food.getPrice() * ((double) food.getDiscount() / 100));
        }
    }
}
