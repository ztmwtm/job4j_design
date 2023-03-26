package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> strings = simpleConvert.toList("first", "second", "three", "four", "five", "six", "seven");
        assertThat(strings).hasSize(7)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1))
                .noneMatch(String::isEmpty)
                .allMatch(s -> Character.isLetter(s.charAt(0)))
                .noneMatch(s -> s.startsWith("a|b|c|d|e|f|g"));
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> strings = simpleConvert.toSet("first", "second", "three", "four", "five", "six", "seven", "first", "first");
        assertThat(strings).hasSize(7)
                .contains("second")
                .contains("first")
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("eight")
                .noneMatch(String::isEmpty)
                .containsOnly("first", "second", "three", "four", "five", "six", "seven")
                .allMatch(s -> Character.isLetter(s.charAt(0)))
                .anyMatch(s -> s.startsWith("s"))
                .noneMatch(s -> s.startsWith("a|b|c|d|e|f|g"));
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> strings = simpleConvert.toMap("first", "second", "three", "four", "five", "six", "seven", "first", "first");
        assertThat(strings).hasSize(7)
                .containsKey("second")
                .containsKey("first")
                .containsEntry("first", 0)
                .doesNotContainKey("eight")
                .doesNotContainValue(-1)
                .containsValues(0, 1, 2, 3, 4, 5, 6);

    }
}