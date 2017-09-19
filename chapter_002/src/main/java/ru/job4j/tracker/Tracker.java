package ru.job4j.tracker;

import java.util.Random;
/**
 * tracker.
 * @author Aleksandr Shigin
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * List of items.
     */
    private Item[] items = new Item[100];
    /**
     * Count of added items.
     */
    private int position = 0;
    /**
     * Random.
     */
    private static final Random RN = new Random();
    /**
     * Generate id.
     * @return new id
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
    /**
     * Add item.
     * @param item - item
     * @return added item
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Update item.
     * @param item - item
     */
    public void update(Item item) {
        int index = 0;
        for (Item value : this.items) {
            if (value.getId().equals(item.getId())) {
                this.items[index] = item;
                break;
            }
            index++;
        }
    }
    /**
     * Delete item.
     * @param item - item
     */
    public void delete(Item item) {
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(item.getId())) {
                System.arraycopy(this.items, index + 1, this.items, index, this.position - index);
                this.items[this.position--] = null;
            }
        }
    }
    /**
     * Find all items.
     * @return Items array without nulls
     */
    public Item[] findAll() {
        Item[] itemsCopy = new Item[this.position];
        System.arraycopy(this.items, 0, itemsCopy, 0, this.position);
        return itemsCopy;
    }
    /**
     * Find items by name.
     * @param key - name
     * @return items array
     */
    public Item[] findByName(String key) {
        Item[] itemsCopy = new Item[this.position];
        int counter = 0;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getName().equals(key)) {
                itemsCopy[counter++] = this.items[index];
            }
        }
        Item[] arrayWithoutNulls = new Item[counter];
        System.arraycopy(itemsCopy, 0, arrayWithoutNulls, 0, counter);
        return arrayWithoutNulls;
    }
    /**
     * Find item by id.
     * @param id - id
     * @return item
     */
    public Item findById(String id) {
        Item item = null;
        for (int index = 0; index < this.position; index++) {
            if (items[index].getId().equals(id)) {
                item = items[index];
            }
        }
        return item;
    }
}
