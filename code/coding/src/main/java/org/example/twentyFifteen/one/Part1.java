package org.example.twentyFifteen.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {

        int floor = 0;
        File inputFile = new File("C:\\Users\\conno\\workspace\\advent-code-challenges\\code\\coding\\src\\main\\java\\org\\example\\resources\\one.txt");
        try {
            Scanner input = new Scanner(inputFile);
            String text = input.next();
            for (Character paran : text.toCharArray()) {
                floor = paran == '(' ? floor + 1 : floor - 1;
            }
            System.out.println(text);
            System.out.println(floor);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}