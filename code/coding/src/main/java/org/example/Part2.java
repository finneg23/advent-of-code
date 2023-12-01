package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {

        int floor = 0;
        File inputFile = new File("C:\\Users\\conno\\workspace\\advent-code-challenges\\code\\coding\\src\\main\\java\\org\\example\\resources\\input.txt");
        try {
            Scanner input = new Scanner(inputFile);
            String text = input.next();
            for (int i = 0; i < text.toCharArray().length; i++) {
                floor = text.toCharArray()[i] == '(' ? floor + 1 : floor - 1;
                if (floor < 0) {
                    System.out.println(i + 1);
                    break;
                }
            }
            System.out.println(text);
            System.out.println(floor);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
