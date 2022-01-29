package ru.job4j.collection;

import ru.job4j.list.List;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        modCount++;
        if (container.length == size) {
            container = grow();
        }
        container[size++] = value;
    }

    @Override
    public T set(int index, T newValue) {
        T oldValue = get(index);
        container[index] = newValue;
        modCount++;
        return oldValue;
    }

    @Override
    public T remove(int index) {
        T oldValue = get(index);
        System.arraycopy(
                container,
                index + 1,
                container,
                index,
                container.length - index - 1);
        container[size - 1] = null;
        size--;
        modCount++;
        return oldValue;
    }

    @Override
    public T get(int index) {
        index = Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private int point = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[point++];
            }

        };
    }

    private T[] grow() {
        container = container.length == 0
                ? Arrays.copyOf(container, 10)
                : Arrays.copyOf(container, container.length * 2);
        return container;
    }
}