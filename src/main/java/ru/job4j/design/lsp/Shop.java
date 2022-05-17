package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {

    private List<Food> foodList = new ArrayList<>();

    @Override
    public boolean store(Food food, double lifeBalance) {
        boolean rsl = false;
        if (sort(lifeBalance)) {
            foodList.add(food);
            rsl = true;
            if (lifeBalance < 25 && lifeBalance >= 0) {
                food.setPrice(food.getPrice() * ((double) food.getDiscount() / 100));
            }
        }

        return rsl;
    }

    @Override
    public boolean sort(double lifeBalance) {
        return lifeBalance >= 0 && lifeBalance <= 75;
    }

    public List<Food> getFoodList() {
        return new ArrayList<>(foodList);
    }
}
