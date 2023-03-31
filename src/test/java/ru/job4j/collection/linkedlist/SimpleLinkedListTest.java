package ru.job4j.collection.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class SimpleLinkedListTest {

    private LinkedList<Integer> list;

    @BeforeEach
    public void initData() {
        list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
    }

    @Test
    void checkIteratorSimple() {
        assertThat(list).hasSize(2);
        list.add(3);
        list.add(4);
        assertThat(list).hasSize(4);
    }

    @Test
    void whenAddAndGetByCorrectIndex() {
        list.add(3);
        assertThat(list.get(2)).isEqualTo(3);
    }

    @Test
    void whenGetByNegativeIndexThenGetException() {
        assertThatThrownBy(() -> list.get(-1))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddNullThenMustBeSameBehavior() {
        list.add(null);
        list.add(null);
        assertThat(list.get(3)).isNull();
        assertThat(list.get(2)).isNull();
    }

    @Test
    void whenGetIteratorFromEmptyListThenNextThrownException() {
        LinkedList<Integer> list = new SimpleLinkedList<>();
        Iterator<Integer> iterator = list.iterator();
        assertThatThrownBy(iterator::next)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void whenGetItertatorTwiceThenStartAlwaysFromBeginning() {
        assertThat(list.iterator().next()).isEqualTo(1);
        assertThat(list.iterator().next()).isEqualTo(1);
    }

    @Test
    void whenAddAfterGetIteratorHasNextMustBeException() {
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.hasNext()).isTrue();
        list.add(3);
        assertThatThrownBy(iterator::hasNext)
                .isInstanceOf(ConcurrentModificationException.class);
    }

    @Test
    void whenAddAfterGetIteratorNextMustBeException() {
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.hasNext()).isTrue();
        list.add(3);
        assertThatThrownBy(iterator::next)
                .isInstanceOf(ConcurrentModificationException.class);
    }

    @Test
    void whenAddAndGet() {
        list.add(3);
        list.add(4);
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(2);
        assertThat(list.get(2)).isEqualTo(3);
        assertThat(list.get(3)).isEqualTo(4);
    }

    @Test
    void whenGetFromOutOfBoundThenExceptionThrown() {
        assertThatThrownBy(() -> list.get(2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddIterHasNextTrue() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext()).isTrue();
    }

    @Test
    void whenAddIterNextOne() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.next()).isEqualTo(1);
    }

    @Test
    void whenEmptyIterHashNextFalse() {
        LinkedList<Integer> list = new SimpleLinkedList<>();
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext()).isFalse();
    }

    @Test
    void whenAddIterMultiHasNextTrue() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext()).isTrue();
        assertThat(it.hasNext()).isTrue();
    }

    @Test
    void whenAddIterNextOneNextTwo() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.next()).isEqualTo(1);
        assertThat(it.next()).isEqualTo(2);
    }

    @Test
    void whenGetIteratorTwiceThenEveryFromBegin() {
        Iterator<Integer> first = list.iterator();
        assertThat(first.hasNext()).isTrue();
        assertThat(first.next()).isEqualTo(1);
        assertThat(first.hasNext()).isTrue();
        assertThat(first.next()).isEqualTo(2);
        assertThat(first.hasNext()).isFalse();
        Iterator<Integer> second = list.iterator();
        assertThat(second.hasNext()).isTrue();
        assertThat(second.next()).isEqualTo(1);
        assertThat(second.hasNext()).isTrue();
        assertThat(second.next()).isEqualTo(2);
        assertThat(second.hasNext()).isFalse();
    }
}