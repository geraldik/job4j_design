package ru.job4j.design.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Distributor {

    public static double lifeBalance(Food food) {
        long fullLife = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long goneLife = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now());
        return (((double) (fullLife - goneLife) / fullLife) * 100);
    }
}
