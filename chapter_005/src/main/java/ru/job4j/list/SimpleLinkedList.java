package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList<E> implements Iterable<E> {

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public void add(E value) {
        Node<E> tmp = last;

        Node<E> newNode = new Node<>(value, tmp, null);
        last = newNode;

        if (first == null) {
            first = newNode;
        } else {
            tmp.next = newNode;
        }
        size++;
    }

    public E get(int index) {
        if (index < size) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.item;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < size;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    return get(position++);
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    private static class Node<E> {
        private E item;
        private Node<E> prev;
        private Node<E> next;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
