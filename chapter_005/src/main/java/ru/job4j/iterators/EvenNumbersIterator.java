package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private final int[] numbers;
    private int index = 0;

    public EvenNumbersIterator(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        if (this.numbers.length > this.index) {
            for (int i = this.index; i < this.numbers.length; i++) {
                if (this.numbers[i] % 2 == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        for (; this.index < this.numbers.length; this.index++) {
            if (this.numbers[this.index] % 2 == 0) {
                return this.numbers[this.index++];
            }
        }
        throw new NoSuchElementException();
    }
}
