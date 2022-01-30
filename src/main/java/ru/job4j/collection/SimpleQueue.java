package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int inSize;
    private int outSize;


    public T poll() {
        if (inSize == 0 && outSize == 0) {
            throw new NoSuchElementException();
        }
        int count = inSize;
        if (outSize == 0) {
            outSize = inSize - 1;
            while (count != 0) {
                out.push(in.pop());
                count--;
            }
        }
        inSize--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        inSize++;
    }
}