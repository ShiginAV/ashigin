package ru.job4j.generic;

public abstract class AbstractStore<T extends Base> implements Store {
    private SimpleArray<T> store;

    public AbstractStore(int size) {
        this.store = new SimpleArray<>(size);
    }

    public T getElement(String id) {
        int position = 0;
        for (T value : this.store) {
            if (value.getId().equals(id)) {
                return this.store.get(position);
            }
            position++;
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T add(Base model) {
        this.store.add((T) model);
        return (T) model;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public T update(Base model) {
        int position = 0;
        for (T value : this.store) {
            if (value.getId().equals(model.getId())) {
                this.store.update((T) model, position);
                return (T) model;
            }
            position++;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        int position = 0;
        for (T value : this.store) {
            if (value.getId().equals(id)) {
                this.store.delete(position);
                return true;
            }
            position++;
        }
        return false;
    }
}
