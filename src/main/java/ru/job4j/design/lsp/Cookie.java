package ru.job4j.design.lsp;

import java.time.LocalDate;

public class Cookie extends Food {

    public Cookie(String name, LocalDate expiryDate, LocalDate createDate, double price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
