package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * StubInputTest.
 * @author Aleksandr Shigin
 * @version $Id$
 * @since 0.1
 */
public class StubInputTest {
    /*** Add item in tracker.*/
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }
    /*** Show all items.*/
    @Test
    public void whenSelectShowAllItemsThenShowAllItemsInTracker() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test", "description", 1L));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test"));
    }
    /*** Edit item.*/
    @Test
    public void whenSelectEditItemThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 1L));
        Input input = new StubInput(new String[]{"2", item.getId(), "new test name", "new desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("new test name"));
    }
    /*** Delete item.*/
    @Test
    public void whenSelectDeleteItemThenItemIsDeleted() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "description", 1L);
        tracker.add(item);
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(new Tracker().findAll()));
    }
    /*** Find item by id.*/
    @Test
    public void whenSelectFindByIdThenShowsFoundItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "description", 1L);
        tracker.add(item);
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getId(), is(item.getId()));
    }
    /*** Find item by name.*/
    @Test
    public void whenSelectFindByNameThenShowsFoundItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test", "description", 1L));
        Input input = new StubInput(new String[]{"5", "test", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("test")[0].getName(), is("test"));
    }
}
