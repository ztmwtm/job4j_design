package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Analize {

    private Analize() {
    }

    public static Info diff(Set<User> previous, Set<User> current) {
        Info result = new Info(0, 0, 0);
        Map<Integer, User> map = new HashMap<>();

        current.forEach(e -> map.put(e.getId(), e));

        for (User user : previous) {
            User curr = map.get(user.getId());
            if (curr == null) {
                result.incDeleted();
            } else if (!Objects.equals(curr, user)) {
                result.incChanged();
            }
        }

        result.setAdded(current.size() - previous.size() + result.getDeleted());
        return result;
    }

}