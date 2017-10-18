package ru.job4j.sortuser;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * SortUserTest.
 * @author Aleksandr Shigin
 * @version $Id$
 * @since 0.1
 */
public class SortUserTest {
    /*** Sort list of users.*/
    @Test
    public void whenListOfUsersThenSortedListOfUsers() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>(
                Arrays.asList(
                        new User("Ivan", 20),
                        new User("Bob", 25),
                        new User("Jack", 15),
                        new User("Ivan", 10),
                        new User("Michael", 10)
                )
        );
        Set<User> expect = new TreeSet<>(
                Arrays.asList(
                        new User("Ivan", 10),
                        new User("Michael", 10),
                        new User("Jack", 15),
                        new User("Ivan", 20),
                        new User("Bob", 25)

                )
        );
        assertThat(sortUser.sort(list), is(expect));
    }
}
