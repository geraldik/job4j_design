package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (data.length == 1) {
            return false;
        }
        int lastEvenIndex = data.length - 1;
        while (data[lastEvenIndex] % 2 != 0
                && lastEvenIndex > 0) {
            lastEvenIndex--;
        }
        while (index < data.length
                && data[index] % 2 != 0) {
            index++;
        }
        return lastEvenIndex >= index;
    }

    @Override
    public Integer next() {
       if (!hasNext()) {
           throw new NoSuchElementException();
       }
        return data[index++];
    }

}