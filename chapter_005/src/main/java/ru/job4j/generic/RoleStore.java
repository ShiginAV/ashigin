package ru.job4j.generic;

public class RoleStore extends AbstractStore {

    public RoleStore(int size) {
        super(size);
    }

    @Override
    public Role getElement(String id) {
        return (Role) super.getElement(id);
    }

    @Override
    public Role add(Base model) {
        return (Role) super.add(model);
    }

    @Override
    public Role update(Base model) {
        return (Role) super.update(model);
    }
}
