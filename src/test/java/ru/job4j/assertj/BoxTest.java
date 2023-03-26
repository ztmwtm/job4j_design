package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name)
                .isEqualTo("Sphere")
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name)
                .isEqualTo("Tetrahedron")
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 10);
        String name = box.whatsThis();
        assertThat(name)
                .isEqualTo("Cube")
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    void isThisUnknownObject() {
        Box box = new Box(100, 10);
        String name = box.whatsThis();
        assertThat(name)
                .isEqualTo("Unknown object")
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    void getNumberOfVerticesZero() {
        Box box = new Box(0, 10);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices)
                .isEqualTo(0)
                .isEven();
    }

    @Test
    void getNumberOfVerticesFour() {
        Box box = new Box(4, 10);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices)
                .isEqualTo(4)
                .isPositive();
    }

    @Test
    void getNumberOfVerticesEight() {
        Box box = new Box(8, 10);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices)
                .isEqualTo(8)
                .isPositive();
    }

    @Test
    void getNumberOfVerticesMinusOne() {
        Box box = new Box(3, 10);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices)
                .isEqualTo(-1)
                .isNegative();
    }

    @Test
    void isExistTrue() {
        Box box = new Box(0, 10);
        boolean isExist = box.isExist();
        assertThat(isExist).isTrue();
    }

    @Test
    void isExistFalse() {
        Box box = new Box(0, 0);
        boolean isExist = box.isExist();
        assertThat(isExist).isFalse();
    }

    @Test
    void getAreaZero() {
        Box box = new Box(1, 1);
        double area = box.getArea();
        assertThat(area)
                .isEqualTo(0, withPrecision(0.001))
                .isZero();
    }

    @Test
    void getAreaOneDotSevenThreeTwo() {
        Box box = new Box(4, 1);
        double area = box.getArea();
        assertThat(area)
                .isEqualTo(1.732, withPrecision(0.001))
                .isGreaterThan(0);

    }

    @Test
    void getAreaSix() {
        Box box = new Box(8, 1);
        double area = box.getArea();
        assertThat(area)
                .isEqualTo(6, withPrecision(0.001))
                .isGreaterThan(0);

    }

}