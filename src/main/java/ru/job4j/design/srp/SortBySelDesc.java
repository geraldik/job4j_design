package ru.job4j.design.srp;

import java.util.Comparator;

public class SortBySelDesc implements Comparator<Employee> {
    @Override
    public int compare(Employee employee1, Employee employee2) {
        return (int) (employee2.getSalary() - employee1.getSalary());
    }
}
