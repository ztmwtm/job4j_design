package ru.job4j.collection.set;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SimpleSetTest {

    @Test
    void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(1)).isTrue();
        assertThat(set.contains(1)).isTrue();
        assertThat(set.add(1)).isFalse();
    }

    @Test
    void whenAddSomeElementsNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.contains(1)).isFalse();
        assertThat(set.add(1)).isTrue();
        assertThat(set.contains(1)).isTrue();
        assertThat(set.add(1)).isFalse();
        assertThat(set.contains(2)).isFalse();
        assertThat(set.add(2)).isTrue();
        assertThat(set.contains(2)).isTrue();
        assertThat(set.add(2)).isFalse();
        assertThat(set.contains(3)).isFalse();
        assertThat(set.add(3)).isTrue();
        assertThat(set.contains(3)).isTrue();
        assertThat(set.add(3)).isFalse();
    }

    @Test
    void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(null)).isTrue();
        assertThat(set.contains(null)).isTrue();
        assertThat(set.add(null)).isFalse();
    }

    @Test
    void whenAddMultiAddThenGet() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(2)).isTrue();
        assertThat(set.add(2)).isFalse();
        assertThat(set.add(2)).isFalse();
        assertThat(set.add(2)).isFalse();
        assertThat(set.add(3)).isTrue();
        assertThat(set.add(2)).isFalse();
        assertThat(set.add(3)).isFalse();
        assertThat(set.add(4)).isTrue();
        assertThat(set.add(4)).isFalse();
        assertThat(set.add(3)).isFalse();
        Iterator<Integer> i = set.iterator();
        assertThat(i.next()).isEqualTo(2);
        assertThat(i.next()).isEqualTo(3);
        assertThat(i.next()).isEqualTo(4);
        assertThatThrownBy(i::next).isInstanceOf(NoSuchElementException.class);
    }
}