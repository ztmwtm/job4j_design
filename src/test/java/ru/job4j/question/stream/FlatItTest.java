package ru.job4j.question.stream;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FlatItTest {
    @Test
    void whenIt() {
        Iterator<Iterator<Integer>> it = List.of(List.of(1).iterator(), List.of(2, 3).iterator()).iterator();
        assertThat(FlatIt.flatten(it))
                .isEqualTo(List.of(1, 2, 3));
    }
}