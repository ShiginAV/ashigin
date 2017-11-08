package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayList<E> implements Iterable<E> {

    private Object[] container;
    private int size = 0;

    public SimpleArrayList() {
        this.container = new Object[10];
    }

    public SimpleArrayList(int capacity) {
        if (capacity == 0) {
            this.container = new Object[]{};
        }
        if (capacity > 0) {
            this.container = new Object[capacity];
        }
    }

    // add element
    public void add(E value) {
        if (size == 0) {
            container = new Object[1];
        }
        if (size >= container.length) {
            container = new Object[container.length + container.length];
        }
        container[size++] = value;
    }

    // get element by index
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) container[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int position = 0;

            @Override
            public boolean hasNext() {
                return container.length > position && container[position] != null;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                if (this.hasNext()) {
                    return (E) container[position++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
