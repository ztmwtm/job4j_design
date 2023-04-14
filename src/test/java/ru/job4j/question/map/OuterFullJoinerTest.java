package ru.job4j.question.map;

import org.junit.jupiter.api.Test;
import ru.job4j.question.map.OuterFullJoiner;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class OuterFullJoinerTest {


    @Test
    void whenNoUnique() {
        var right = List.of(1, 2, 3);
        var left = List.of(1, 2, 3);
        var expected = List.of();
        var result = OuterFullJoiner.extractUnique(left, right);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenFullUnique() {
        var right = List.of(1, 2, 3);
        var left = List.of(4, 5, 6);
        var expected = List.of(1, 2, 3, 4, 5, 6);
        var result = OuterFullJoiner.extractUnique(left, right);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenLeftDuplicate() {
        var right = List.of(1, 2, 3);
        var left = List.of(1, 2, 3, 4, 5, 6);
        var expected = List.of(4, 5, 6);
        var result = OuterFullJoiner.extractUnique(left, right);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenRightDuplicate() {
        var right = List.of(1, 2, 3, 4, 5, 6);
        var left = List.of(1, 2, 3);
        var expected = List.of(4, 5, 6);
        var result = OuterFullJoiner.extractUnique(left, right);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenMultiplyDuplicates() {
        var right = List.of(1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1, 99, 98);
        var left = List.of(1, 2, 3, 4, 5, 6, 6, 11, 12, 13);
        var expected = List.of(11, 12, 13, 98, 99);
        var result = OuterFullJoiner.extractUnique(left, right);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenMillionUnits() {
        var right = Stream.iterate(1, e -> (e + 1) * 2).limit(1_000_000).toList();
        var left = Stream.iterate(1, e -> (e + 1) * 2).limit(1_000_000).toList();
        var expected = List.of();
        var result = OuterFullJoiner.extractUnique(left, right);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenMillionUnitsWithResult() {
        var right = Stream.iterate(0, e -> e + 2).limit(1_000_000).toList();
        var left = Stream.iterate(0, e -> e + 3).limit(1_000_000).toList();
        var expected = Stream.iterate(0, e -> e + 3).limit(1_000_000).toList();
        var result = OuterFullJoiner.extractUnique(left, right);
        assertThat(result).isEqualTo(expected);
    }
}