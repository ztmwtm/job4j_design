package ru.job4j.question.map;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class OuterFullJoiner {

    private OuterFullJoiner() {
    }

    public static List<Integer> extractUnique(List<Integer> left, List<Integer> right) {
        //(O) = 2n^3 SEEK!!!
        return Stream.of(left, right).flatMap(Collection::stream).filter(e -> !(right.contains(e) && left.contains(e))).sorted().toList();
    }
}
