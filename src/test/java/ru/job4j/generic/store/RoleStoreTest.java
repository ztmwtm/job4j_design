package ru.job4j.generic.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoleStoreTest {

    private RoleStore store;

    @BeforeEach
    public void setUp() {
        store = new RoleStore();
    }

    @Test
    void whenAddNull() {
        assertThatThrownBy(() -> store.add(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void whenAddAndFindRole() {
        Role role = new Role("1", "HR");
        store.add(role);
        Role result = store.findById("1");
        assertThat(role.getRole()).isEqualTo(result.getRole());
    }

    @Test
    public void whenUserIsNotPresent() {
        Role result = store.findById("1000");
        assertThat(result).isNull();
    }

    @Test
    public void whenDeleteOkThenFindByIdNull() {
        Role role = new Role("666", "Devil");
        store.add(role);
        assertThat(store.delete("666")).isTrue();
        assertThat(store.findById("666")).isNull();
    }

    @Test
    public void whenDeleteNotOkThenFindByIdNull() {
        assertThat(store.delete("999")).isFalse();
        assertThat(store.findById("999")).isNull();
    }


    @Test
    public void whenReplaceOkThenFindByIdOk() {
        Role roleOne = new Role("007", "PierceBrosnan");
        Role roleTwo = new Role("007", "Daniel Craig");
        store.add(roleOne);
        assertThat(store.replace("007", roleTwo)).isTrue();
        assertThat(store.findById("007").getRole()).isEqualTo(roleTwo.getRole());
    }

    @Test
    public void whenReplaceNotOk() {
        Role roleOne = new Role("42", "The Ultimate Question of Life, the Universe, and Everything");
        Role roleTwo = new Role("000", "Zero");
        store.add(roleOne);
        assertThat(store.replace("000", roleTwo)).isFalse();
        assertThat(store.findById("000")).isNull();
    }

    @Test
    public void whenAddDuplicateRole() {
        Role roleOne = new Role("0", "Zero");
        Role roleTwo = new Role("0", "zero");
        store.add(roleOne);
        store.add(roleTwo);
        assertThat(store.findById("0").getRole()).isEqualTo(roleOne.getRole());
        assertThat(store.findById("0").getRole()).isNotEqualTo(roleTwo.getRole());
    }
}