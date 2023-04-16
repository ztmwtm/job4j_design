package ru.job4j.io;

import java.io.FileInputStream;
import java.util.Arrays;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("data/even.txt")) {
            StringBuilder text = new StringBuilder();
            String[] strings;
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            strings = text.toString().split(System.lineSeparator());
            Arrays.stream(strings)
                    .map(Integer::valueOf)
                    .filter(e -> e % 2 == 0)
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}