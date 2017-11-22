package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        User first = new User("Ivan", 1, new GregorianCalendar(1980, Calendar.NOVEMBER, 15));
        User second = new User("Ivan", 1, new GregorianCalendar(1980, Calendar.NOVEMBER, 15));

        Map<User, Object> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");

        System.out.println(map);
    }
}
