package ru.job4j.generic.store;

public abstract class Base {

    private final String id;

    public Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}