package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/dataresult.txt")) {
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    String temp = String.format("%d * %d = %2d   ", i, j, i * j);
                    out.write(temp.getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}