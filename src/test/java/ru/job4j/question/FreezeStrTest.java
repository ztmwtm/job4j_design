package ru.job4j.question;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FreezeStrTest {

    @Test
    void whenEq() {
        assertThat(FreezeStr.eq("Hello", "Hlloe")).isTrue();
    }

    @Test
    void whenNotEq() {
        assertThat(FreezeStr.eq("Hello", "Halle")).isFalse();
    }

    @Test
    void whenNotMultiEq() {
        assertThat(FreezeStr.eq("heloo", "hello")).isFalse();
    }
}