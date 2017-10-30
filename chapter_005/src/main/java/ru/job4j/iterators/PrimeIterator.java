package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator<Integer> {

    private final int[] numbers;
    private int index = 0;

    public PrimeIterator(int[] numbers) {
        this.numbers = numbers;
    }

    private boolean isPrime(int indx) {
        if (this.numbers[indx] != 1) {
            boolean flag = true;
            for (int j = 2; j <= this.numbers[indx] / 2; j++) {
                if (this.numbers[indx] % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        if (this.numbers.length > this.index) {
            for (int i = this.index; i < this.numbers.length; i++) {
                if (this.isPrime(i)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        for (; this.index < this.numbers.length; this.index++) {
            if (this.isPrime(this.index)) {
                return this.numbers[this.index++];
            }
        }
        throw new NoSuchElementException();
    }
}
