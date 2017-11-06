package ru.job4j.generic;

public class UserStore extends AbstractStore {

    public UserStore(int size) {
        super(size);
    }

    @Override
    public User getElement(String id) {
        return (User) super.getElement(id);
    }

    @Override
    public User add(Base model) {
        return (User) super.add(model);
    }

    @Override
    public User update(Base model) {
        return (User) super.update(model);
    }
}
