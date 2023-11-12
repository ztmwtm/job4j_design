package ru.job4j;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class IntTask {
    public static void main(String[] args) {
        try  {
            Reader reader = new FileReader("C:\\123.txt");
            while (reader.ready()) {
                System.out.println(reader.read());
            }
        }
        catch (IOException e) {
            System.err.println("IOExceprion Catched!!");
        }
    }
}
