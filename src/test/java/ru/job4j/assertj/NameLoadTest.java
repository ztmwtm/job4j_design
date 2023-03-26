package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkParseZeroArgs() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");

    }

    @Test
    void checkWrongFormat() {
        NameLoad nameLoad = new NameLoad();
        String data = "Bad Data";
        assertThatThrownBy(() -> nameLoad.parse(data))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(data)
                .hasMessageContaining("does not contain the symbol \"=\"");
    }

    @Test
    void checkEmptyKey() {
        NameLoad nameLoad = new NameLoad();
        String data = "=Data";
        assertThatThrownBy(() -> nameLoad.parse(data))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(data)
                .hasMessageContaining("does not contain a key");
    }

    @Test
    void checkEmptyValue() {
        NameLoad nameLoad = new NameLoad();
        String data = "Data=";
        assertThatThrownBy(() -> nameLoad.parse(data))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(data)
                .hasMessageContaining("does not contain a value");
    }
}