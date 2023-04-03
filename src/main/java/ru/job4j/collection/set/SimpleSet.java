package ru.job4j.collection.set;

import ru.job4j.collection.simplelist.SimpleArrayList;

import java.util.*;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(0);

    @Override
    public boolean add(T value) {
        boolean isAdded = false;
        if (!this.contains(value)) {
            set.add(value);
            isAdded = true;
        }
        return isAdded;
    }

    @Override
    public boolean contains(T value) {
        boolean isContains = false;
        for (T element : set) {
            if (Objects.equals(element, value)) {
                isContains = true;
                break;
            }
        }
        return isContains;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}