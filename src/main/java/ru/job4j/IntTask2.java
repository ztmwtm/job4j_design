package ru.job4j;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class IntTask2 {
    public static void main(String[] args) throws IOException {
        Reader reader = null;
        try {
//            throw new Exception("");
            reader = new FileReader("C:\\test\\1.txt");
        } catch (IOException ioException) {
            System.err.println("IOException");
        } catch (Exception e) {
            System.err.println("Exceprion");
        } finally {
            System.err.println("Finally block");
            reader.close();
        }
    }
}
