package ru.job4j.design.icp.menu;

public class SimpleMenuPrinter implements MenuPrinter {
    @Override
    public void print(Menu menu) {
        menu.forEach(i -> System.out.println("\t".repeat(i.getNumber().split("\\.").length - 1)
                + i.getNumber() + i.getName()));

    }
}
