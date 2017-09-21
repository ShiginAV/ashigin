package ru.job4j.tracker;
/**
 * MenuTracker.
 * @author Aleksandr Shigin
 * @version $Id$
 * @since 0.1
 */
public class MenuTracker {
    /*** Input.*/
    private Input input;
    /*** Tracker.*/
    private Tracker tracker;
    /*** Array of actions.*/
    private UserAction[] actions = new UserAction[7];
    /**
     * Constructor.
     * @param input - input
     * @param tracker - tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /*** Fills an array of actions.*/
    public void fillActions() {
        this.actions[0] = new MenuTracker.AddNewItem();
        this.actions[1] = new MenuTracker.ShowAllItems();
        this.actions[2] = new MenuTracker.EditItem();
        this.actions[3] = new MenuTracker.DeleteItem();
        this.actions[4] = new MenuTracker.FindByName();
        this.actions[5] = new MenuTracker.FindById();
    }
    /**
     * Select action.
     * @param key - key
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }
    /*** Show menu.*/
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /***Add new item.*/
    private static class AddNewItem implements UserAction {
        /**
         * Get key.
         * @return - key
         */
        @Override
        public int kay() {
            return 0;
        }
        /**
         * Add new item.
         * @param input - input
         * @param tracker - tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter name of new item: ");
            String desc = input.ask("Enter description of new item: ");
            tracker.add(new Item(name, desc, 1L));
        }
        /**
         * Show menu item.
         * @return - string
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.kay(), " Add new Item");
        }
    }

    /***Show all items.*/
    private static class ShowAllItems implements UserAction {
        /**
         * Get key.
         * @return - key
         */
        @Override
        public int kay() {
            return 1;
        }
        /**
         * Show all items.
         * @param input - input
         * @param tracker - tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println("[ " + item.getId() + " | " + item.getName() + " | " + item.getDescription() + " ]");
            }
        }
        /**
         * Show menu item.
         * @return - string
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.kay(), " Show all items");
        }
    }

    /***Edit item.*/
    private static class EditItem implements UserAction {
        /**
         * Get key.
         * @return - key
         */
        @Override
        public int kay() {
            return 2;
        }
        /**
         * Edit item.
         * @param input - input
         * @param tracker - tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
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
         * Show menu item.
         * @return - string
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.kay(), " Edit item");
        }
    }

    /***Delete item.*/
    private static class DeleteItem implements UserAction {
        /**
         * Get key.
         * @return - key
         */
        @Override
        public int kay() {
            return 3;
        }
        /**
         * Delete item.
         * @param input - input
         * @param tracker - tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter id of item: ");
            Item item = tracker.findById(id);
            if (item != null) {
                tracker.delete(item);
            }
        }
        /**
         * Show menu item.
         * @return - string
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.kay(), " Delete item");
        }
    }

    /***Find by name.*/
    private static class FindByName implements UserAction {
        /**
         * Get key.
         * @return - key
         */
        @Override
        public int kay() {
            return 4;
        }
        /**
         * Find by name.
         * @param input - input
         * @param tracker - tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter name of item: ");
            for (Item item : tracker.findByName(name)) {
                System.out.println("[ " + item.getId() + " | " + item.getName() + " | " + item.getDescription() + " ]");
            }
        }
        /**
         * Show menu item.
         * @return - string
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.kay(), " Find by name");
        }
    }

    /***Find by id.*/
    private static class FindById implements UserAction {
        /**
         * Get key.
         * @return - key
         */
        @Override
        public int kay() {
            return 5;
        }
        /**
         * Find by id.
         * @param input - input
         * @param tracker - tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter id of item: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println("[ " + item.getId() + " | " + item.getName() + " | " + item.getDescription() + " ]");
            }
        }
        /**
         * Show menu item.
         * @return - string
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.kay(), " Find by id");
        }
    }
}
