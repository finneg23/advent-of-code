package org.example.twentyTwentyThree.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Part1 {
    public static void main (String[] args) {
        File inputFile = new File("C:\\Users\\conno\\workspace\\advent-code-challenges\\code\\coding\\src\\main\\java\\org\\example\\resources\\twentyTwentyThree\\one.txt");
        try {
            List<String> calibrations = new ArrayList<>();
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split("[a-zA-Z]+");
                String testing = "";
                for (String testie : split) {
                    testing += testie;
                }
                String[] splitMore = testing.split("");
                if (splitMore.length < 2) {
                    calibrations.add(splitMore[0] + splitMore[0]);
                } else {
                    calibrations.add(splitMore[0] + splitMore[splitMore.length-1]);
                }
            }
            int sum = 0;
            for (String test : calibrations) {
                System.out.println(test);
                sum += Integer.parseInt(test);
            }
            System.out.println("Tada! --> " + sum);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
