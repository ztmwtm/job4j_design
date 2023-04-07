package ru.job4j.collection.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            count = 0;
            expand();
            modCount++;
        }
        boolean isPutted = false;
        int index = key == null ? 0 : indexFor(hash(key.hashCode()));
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            isPutted = true;
            modCount++;
            count++;
        }
        return isPutted;
    }

    private int hash(int hashcode) {
        return hashcode ^ hashcode >>> 16;
    }

    private int indexFor(int hash) {
        return (hash & (capacity - 1));
    }

    private void expand() {
        capacity = capacity << 1;
        MapEntry<K, V>[] oldTable = table;
        table = new MapEntry[capacity];
        for (MapEntry<K, V> entry : oldTable) {
            if (entry != null) {
                put(entry.key, entry.value);
            }
        }
    }

    @Override
    public V get(K key) {
        int index = key == null ? 0 : indexFor(hash(key.hashCode()));
        V value = null;
        if (table[index] != null) {
            value = compareKeys(key, table[index].key) ? table[index].value : null;
        }
        return value;
    }

    private boolean compareKeys(K firstKey, K secondKey) {
        return (Objects.isNull(firstKey) && Objects.isNull(secondKey))
                || (Objects.nonNull(firstKey) && Objects.nonNull(secondKey)
                && firstKey.hashCode() == secondKey.hashCode()
                && firstKey.equals(secondKey));
    }

    @Override
    public boolean remove(K key) {
        boolean isRemoved = false;
        int index = key == null ? 0 : indexFor(hash(key.hashCode()));
        if (table[index] != null) {
            if (compareKeys(key, table[index].key)) {
                table[index] = null;
                isRemoved = true;
                modCount++;
                count--;
            }
        }
        return isRemoved;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            int currModCount = modCount;
            int index = 0;

            @Override
            public boolean hasNext() {
                if (currModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < capacity && table[index] == null) {
                    index++;
                }
                return index < capacity;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
