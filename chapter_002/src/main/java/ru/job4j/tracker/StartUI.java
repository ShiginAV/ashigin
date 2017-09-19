package ru.job4j.tracker;
/**
 * StartUI.
 * @author Aleksandr Shigin
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /*** Menu item - 0. Add new Item*/
    private static final String ADD = "0";
    /*** Menu item - 1. Show all items*/
    private static final String SHOW = "1";
    /*** Menu item - 2. Edit item*/
    private static final String EDIT = "2";
    /*** Menu item - 3. Delete item*/
    private static final String DELETE = "3";
    /*** Menu item - 4. Find item by Id*/
    private static final String FIND_BY_ID = "4";
    /*** Menu item - 5. Find items by name*/
    private static final String FIND_BY_NAME = "5";
    /*** Menu item - 6. Exit Program*/
    private static final String EXIT = "6";
    /*** Input.*/
    private Input input;
    /*** Tracker.*/
    private Tracker tracker;
    /**
     * Constructor.
     * @param input - input
     * @param tracker - tracker
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Add a new item.
     * @param tracker - tracker
     */
    private void addNewItem(Tracker tracker) {
        String name = input.ask("Enter name of new item: ");
        String desc = input.ask("Enter description of new item: ");
        tracker.add(new Item(name, desc, 1L));
    }
    /**
     * Show all items.
     * @param tracker - tracker
     */
    private void showAllItems(Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println("[ " + item.getId() + " | " + item.getName() + " | " + item.getDescription() + " ]");
        }
    }
    /**
     * Edit item.
     * @param tracker - tracker
     */
    private void editItem(Tracker tracker) {
        String id = input.ask("Enter id of item: ");
        Item previous = tracker.findById(id);
        if (previous != null) {
            String name = input.ask("Enter new name of item: ");
            String desc = input.ask("Enter new description of item: ");
            Item next = new Item(name, desc, 1L);
            next.setId(previous.getId());
            tracker.update(next);
        }
    }
    /**
     * Delete item.
     * @param tracker - tracker
     */
    private void deleteItem(Tracker tracker) {
        String id = input.ask("Enter id of item: ");
        Item item = tracker.findById(id);
        if (item != null) {
            tracker.delete(item);
        }

    }
    /**
     * Find item by name.
     * @param tracker - tracker
     */
    private void findItemsByName(Tracker tracker) {
        String name = input.ask("Enter name of item: ");
        for (Item item : tracker.findByName(name)) {
            System.out.println("[ " + item.getId() + " | " + item.getName() + " | " + item.getDescription() + " ]");
        }
    }
    /**
     * Find item by id.
     * @param tracker - tracker
     */
    private void findItemById(Tracker tracker) {
        String id = input.ask("Enter id of item: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("[ " + item.getId() + " | " + item.getName() + " | " + item.getDescription() + " ]");
        }

    }
    /***  Tracker menu.*/
    public void init() {
        String menuItem;
        /*
        0. Add new Item
        1. Show all items
        2. Edit item
        3. Delete item
        4. Find item by Id
        5. Find items by name
        6. Exit Program
        Select:
        */
        do {
            System.out.println("\n0. Add new Item\n1. Show all items\n2. Edit item\n3. Delete item\n4. Find item by Id\n5. Find items by name\n6. Exit Program");
            menuItem = input.ask("Select: ");
            switch (menuItem) {
                case ADD: this.addNewItem(this.tracker); break;
                case SHOW: this.showAllItems(this.tracker); break;
                case EDIT: this.editItem(this.tracker); break;
                case DELETE: this.deleteItem(this.tracker); break;
                case FIND_BY_ID: this.findItemById(this.tracker); break;
                case FIND_BY_NAME: this.findItemsByName(this.tracker); break;
                default: break;
            }
        } while (!EXIT.equals(menuItem));
    }
    /**
     * Mine method.
     * @param args - args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
