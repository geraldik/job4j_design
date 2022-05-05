package ru.job4j.design.ocp;

import java.util.List;

/**
 * При наследовании класса Tool наследник будет обязан переопределить метод repair, при этом
 * для потомка может не быть потребности в этом методе, что нарушит принцип расширяемости.
 */

abstract public class Tool {

    private double price;
    private double weight;

    abstract public void repair();

    private static class Screwdriver extends Tool {

        @Override
        public void repair() {
            System.out.println("repair with screwdriver");
        }
    }

    private static class Hummer extends Tool {

        @Override
        public void repair() {
            System.out.println("repair with hummer");
        }
    }

    public static void main(String[] args) {
        List<Tool> tools = List.of(new Screwdriver(),
                                   new Hummer());
        tools.forEach(Tool::repair);
    }
}
