package ru.job4j.map;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleMapTest {

    @Test
    public void whenAddNonNullSameKey() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put(123, "Ivanov"));
        assertFalse(simpleMap.put(123, "Petrov"));
    }

    @Test
    public void whenAddNonNullNotSameKey() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put(123, "Ivanov"));
        assertTrue(simpleMap.put(1234, "Petrov"));
    }

    @Test
    public void whenAddNonNullThanGet() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        simpleMap.put(123, "Ivanov");
        assertThat(simpleMap.get(123), is("Ivanov"));
    }

    @Test
    public void whenAddNonNullThanGetNull() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        simpleMap.put(123, "Ivanov");
        assertNull(simpleMap.get(321));
    }

    @Test
    public void whenAddNonNullThanRemove() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        simpleMap.put(123, "Ivanov");
        assertTrue(simpleMap.remove(123));
        assertNull(simpleMap.get(123));
    }

    @Test
    public void whenAddNonNullThanRemoveWrongKey() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        simpleMap.put(123, "Ivanov");
        assertFalse(simpleMap.remove(321));
    }
}