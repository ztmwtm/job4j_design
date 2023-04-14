package ru.job4j.question.stream;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class FlatIt {

    private FlatIt() {
    }

    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
        return iteratorToStream(it).flatMap(e -> StreamSupport.stream(Spliterators.spliteratorUnknownSize(e, Spliterator.ORDERED),false)).toList();
    }

    private static <T> Stream<T> iteratorToStream(Iterator<T> it) {
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(it, Spliterator.ORDERED),
                false);
    }
}
