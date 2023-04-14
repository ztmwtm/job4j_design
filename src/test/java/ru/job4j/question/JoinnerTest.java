package ru.job4j.question;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class JoinnerTest {

    @Test
    void whenNoDuplicate() {
        var right = List.of(1, 2, 3);
        var left = List.of(4, 5, 6);
        var expected = List.of();
        var result = Joinner.extractDuplicates(left, right);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenNoDuplicateButDuplicateValuesInRight() {
        var right = List.of(1, 2, 3, 1, 2, 3);
        var left = List.of(4, 5, 6);
        var expected = List.of();
        var result = Joinner.extractDuplicates(left, right);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenFullDuplicate() {
        var right = List.of(1, 2, 3);
        var left = List.of(1, 2, 3);
        var expected = List.of(1, 2, 3);
        var result = Joinner.extractDuplicates(left, right);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenLeftDuplicate() {
        var right = List.of(1, 2, 3);
        var left = List.of(1, 2, 3, 4, 5, 6);
        var expected = List.of(1, 2, 3);
        var result = Joinner.extractDuplicates(left, right);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenRightDuplicate() {
        var right = List.of(1, 2, 3, 4, 5, 6);
        var left = List.of(1, 2, 3);
        var expected = List.of(1, 2, 3);
        var result = Joinner.extractDuplicates(left, right);
        assertThat(result).isEqualTo(expected);
    }
}