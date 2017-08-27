package ru.job4j.max;

/**
 * Max value.
 * @author Aleksandr Shigin
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * max.
     * @param first - first value
     * @param second - second value
     * @return first or second
     */
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }
}
