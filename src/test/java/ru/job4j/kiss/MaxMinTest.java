package ru.job4j.kiss;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.set.Set;
import ru.job4j.set.SimpleSet;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;


public class MaxMinTest {

    @Test
    public void whenMaxIs10() {
        List<Integer> list = List.of(1, 3, 5, 10, 6);
        MaxMin maxMin = new MaxMin();
        assertThat(maxMin.max(list, Comparator.comparingInt((t) -> t)), Is.is(10));
    }

    @Test
    public void whenMinIs1() {
        List<Integer> list = List.of(1, 3, 5, 10, 6);
        MaxMin maxMin = new MaxMin();
        assertThat(maxMin.min(list, Comparator.comparingInt((t) -> t)), Is.is(1));
    }

}