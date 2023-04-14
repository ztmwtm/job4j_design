package ru.job4j.question;

import java.util.List;

public class Joinner {

    private Joinner() {
    }
    public static List<Integer> extractDuplicates(List<Integer> left, List<Integer> right) {

        return left.stream().filter(right::contains).toList();
    }
}
