package ru.job4j.generic;

public class SimpleArray<T> {

    private Object[] objects;
    private int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T value) {
        this.objects[this.index++] = value;
    }

    @SuppressWarnings("unchecked")
    public T get(int position) {
        return (T) this.objects[position];
    }

    public void update(T value, int position) {
        this.objects[position] = value;
    }

    public void delete(int position) {
        this.objects[position] = null;
    }
}
