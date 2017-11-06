package ru.job4j.generic;

public abstract class AbstractStore implements Store {

    private SimpleArray<Base> store;

    public AbstractStore(int size) {
        this.store = new SimpleArray<>(size);
    }

    public Base getElement(String id) {
        int position = 0;
        for (Base value : this.store) {
            if (value.getId().equals(id)) {
                return this.store.get(position);
            }
            position++;
        }
        return null;
    }

    @Override
    public Base add(Base model) {
        this.store.add(model);
        return model;
    }

    @Override
    public Base update(Base model) {
        int position = 0;
        for (Base value : this.store) {
            if (value.getId().equals(model.getId())) {
                this.store.update(model, position);
                return model;
            }
            position++;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        int position = 0;
        for (Base value : this.store) {
            if (value.getId().equals(id)) {
                this.store.delete(position);
                return true;
            }
            position++;
        }
        return false;
    }
}
