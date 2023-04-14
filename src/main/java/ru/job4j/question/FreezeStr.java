package ru.job4j.question;

import java.util.Map;
import java.util.stream.Collectors;

public class FreezeStr {

    private FreezeStr() {
    }

    public static boolean eq(String left, String right) {
        Map<Integer, Integer> leftMap = left.chars().boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        Map<Integer, Integer> rightMap = right.chars().boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));

        return leftMap.equals(rightMap);
    }
}