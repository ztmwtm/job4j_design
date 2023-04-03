package ru.job4j.collection.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class ListUtilsTest {

    private List<Integer> input;
    private List<Integer> testList;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 2, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddBeforeInSingleElementList() {
        input = new ArrayList<>(List.of(1));
        ListUtils.addBefore(input, 0, 0);
        assertThat(input).hasSize(2).containsSequence(0, 1);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddAfterWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addAfter(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfterInSingleElementList() {
        input = new ArrayList<>(List.of(1));
        ListUtils.addAfter(input, 0, 0);
        assertThat(input).hasSize(2).containsSequence(1, 0);
    }

    @Test
    void whenAddThenAddAfter() {
        input.add(2);
        input.add(2);
        ListUtils.addAfter(input, 3, 2);
        assertThat(input).hasSize(5).containsSequence(1, 3, 2, 2, 2);
    }

    @Test
    void whenAddAfterInEmptyList() {
        input = new ArrayList<>();
        assertThatThrownBy(() -> ListUtils.addAfter(input, 0, 0))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddBeforeInEmptyList() {
        input = new ArrayList<>();
        assertThatThrownBy(() -> ListUtils.addBefore(input, 0, 0))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenRemoveAll() {
        testList = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.removeAll(input, testList);
        assertThat(input).hasSize(0).isEmpty();
    }

    @Test
    void whenAddThenRemoveAll() {
        input.add(2);
        testList = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.removeAll(input, testList);
        assertThat(input).hasSize(0).isEmpty();
    }

    @Test
    void whenRemoveByPredicate() {
        ListUtils.removeIf(input, e -> e % 2 != 0);
        assertThat(input).hasSize(0).isEmpty();
    }

    @Test
    void whenAddThenRemoveByPredicate() {
        input.add(2);
        ListUtils.removeIf(input, e -> e % 2 != 0);
        assertThat(input).hasSize(1).contains(2);
    }

    @Test
    void whenReplaceByPredicate() {
        ListUtils.replaceIf(input, e -> e % 2 != 0, 100);
        assertThat(input).hasSize(2).containsSequence(100, 100);
    }

    @Test
    void whenAddThenReplaceByPredicate() {
        input.add(2);
        ListUtils.replaceIf(input, e -> e % 2 != 0, 100);
        assertThat(input).hasSize(3).containsSequence(100, 100, 2);
    }

    @Test
    void whenReplaceByPredicateNoMatches() {
        ListUtils.replaceIf(input, e -> e == 100, 100);
        assertThat(input).hasSize(2).containsSequence(1, 3);
    }

    @Test
    void whenRemoveByPredicateNoMatches() {
        ListUtils.removeIf(input, e -> e == 100);
        assertThat(input).hasSize(2).containsSequence(1, 3);
    }

    @Test
    void whenRemoveAllNoMatches() {
        testList = new ArrayList<>(Arrays.asList(2, 4, 5));
        ListUtils.removeAll(input, testList);
        assertThat(input).hasSize(2).containsSequence(1, 3);
    }
}