package ru.job4j.create_update_insert;

import java.util.List;

public class Item {
    private String id;
    private String description;
    private User user;
    private List<Comments> comments;
    private List<Attaches> attaches;
    private Category category;
    private State state;
}
