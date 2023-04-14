package ru.job4j.question.map;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MultiAssign {

    public static List<Integer> multiAssign(List<Task> tasks) {
        Map<Integer, Integer> tasksMap = tasks.stream().collect(Collectors.toMap(Task::assignId, Task::taskId, Integer::sum));
        return tasksMap.entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).toList();
    }

    public record Task(Integer taskId, Integer assignId) {
    }
}
