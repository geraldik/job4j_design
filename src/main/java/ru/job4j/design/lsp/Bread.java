package ru.job4j.design.lsp;

import java.time.LocalDate;
import java.util.Date;

public class Bread extends Food {

    public Bread(String name, LocalDate expiryDate, LocalDate createDate, double price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
