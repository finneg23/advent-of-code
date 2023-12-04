package org.example.twentyTwentyThree.two;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        int sum = 0;
        File inputFile = new File("C:\\Users\\conno\\workspace\\advent-code-challenges\\code\\coding\\src\\main\\java\\org\\example\\resources\\twentyTwentyThree\\two.txt");
        try {
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String nl = scanner.nextLine();

                boolean done = false;
                int startingIndex = 0;
                int minRed = 0;
                int minBlue = 0;
                int minGreen = 0;
                for (int i = 5; !done; i++) {
                    if (nl.charAt(i) == ':') {
                        done = true;
                        startingIndex = i + 1;
                    }
                }
                nl = nl.substring(startingIndex);
                String[] games = nl.split(";");
                for (String game : games) {
                    String[] draws = game.split(",");
                    for (String draw : draws) {
                        String[] numAndColor = draw.split(" ");
                        int count = Integer.parseInt(numAndColor[1]);
                        if (numAndColor[2].equals("red") && count > minRed) {
                            minRed = count;
                        } else if (numAndColor[2].equals("blue") && count > minBlue) {
                            minBlue = count;
                        } else if (numAndColor[2].equals("green") && count > minGreen) {
                            minGreen = count;
                        }
                    }
                }
                int power = minRed * minGreen * minBlue;
                sum += power;
            }
            System.out.println(sum + ":) :) :)");
            }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}