package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;
    private int lastEvenIndex;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
        lastEvenIndex = data.length - 1;
        while (data[lastEvenIndex] % 2 != 0
                && lastEvenIndex > 0) {
            lastEvenIndex--;
        }
    }

    @Override
    public boolean hasNext() {
        return data.length > 1 && lastEvenIndex >= index;
    }

    @Override
    public Integer next() {
       if(!hasNext()) {
           throw new NoSuchElementException();
       }
        while (data[index] % 2 != 0) {
           index++;
       }
        return data[index++];
    }

}