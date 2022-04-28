package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return getT(value, comparator, t -> t < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return getT(value, comparator, t -> t > 0);
    }

    private <T> T getT(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T rsl = value.get(0);
        for (T t : value) {
            if (predicate.test(comparator.compare(rsl, t)))  {
                rsl = t;
            }
        }
        return rsl;
    }
}