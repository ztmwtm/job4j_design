package ru.job4j.question.stream;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class FlatIt {

    private FlatIt() {
    }

    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
        return iteratorToStream(it).
                flatMap(e -> StreamSupport.stream(Spliterators.spliteratorUnknownSize(e, Spliterator.ORDERED), false))
                .toList();
    }

    private static <T> Stream<T> iteratorToStream(Iterator<T> it) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, Spliterator.ORDERED), false);
    }

    public static void showArray(Integer[] data) {
        Stream.iterate(0, i -> i < data.length, i -> i + 2)
                .forEach(i -> System.err.println(data[i]));
    }

    public static void main(String[] args) {
        showArray(new Integer[]{1, 2, 3, 4, 5, 6});
    }

    public static Stream<Object> createStream(Integer[] data) {
        return Stream.builder().add(data[0]).add(data[data.length - 1]).build();
    }
}
