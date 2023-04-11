package ru.job4j.collection;

import java.util.*;
import java.util.regex.Pattern;

public class Article {

    private Article() {
    }

    public static boolean generateBy(String origin, String line) {
        Pattern pattern = Pattern.compile("[.!,]");
        List<String> listOrigin = new ArrayList<>(Arrays.asList(origin.split(" ")));
        listOrigin = listOrigin.stream().map(String::toLowerCase).map(e -> e.replaceAll(String.valueOf(pattern), "")).toList();
        List<String> listLine = new ArrayList<>(Arrays.asList(line.split(" ")));
        listLine = listLine.stream().map(String::toLowerCase).map(e -> e.replaceAll(String.valueOf(pattern), "")).toList();

        Map<String, Integer> map = new HashMap<>();
        listLine.forEach(e -> map.merge(e, 1, Integer::sum));

        listOrigin.forEach(e -> {
            if (map.containsKey(e)) {
                map.merge(e, 1, (integer, integer2) -> integer - integer2);
            }
        });
        return map.entrySet().stream().noneMatch(e -> e.getValue() > 0);
    }
}
