package ru.job4j.generic;

public class RoleStore<T extends Base> extends AbstractStore<T> {

    public RoleStore(int size) {
        super(size);
    }
}
