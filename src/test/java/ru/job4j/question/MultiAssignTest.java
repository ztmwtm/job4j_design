package ru.job4j.question;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MultiAssignTest {
    @Test
    void whenMulti() {
        var input = List.of(
                new MultiAssign.Task(1, 1),
                new MultiAssign.Task(1, 2),
                new MultiAssign.Task(1, 1)
        );
        var expected = List.of(1);
        var result = MultiAssign.multiAssign(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenOnlyUnique() {
        var input = List.of(
                new MultiAssign.Task(1, 1),
                new MultiAssign.Task(1, 2),
                new MultiAssign.Task(1, 3)
        );
        var expected = List.of();
        var result = MultiAssign.multiAssign(input);
        assertThat(result).isEqualTo(expected);
    }
}