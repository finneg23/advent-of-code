package org.example.twentyTwentyThree.two;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        int sum = 0;
        File inputFile = new File("C:\\Users\\conno\\workspace\\advent-code-challenges\\code\\coding\\src\\main\\java\\org\\example\\resources\\twentyTwentyThree\\two.txt");
        try {
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String nl = scanner.nextLine();
                String idString = "";
                boolean done = false;
                int startingIndex = 0;
                int maxRed = 12;
                int maxGreen = 13;
                int maxBlue = 14;
                boolean possible = true;
                for (int i = 5; !done; i++) {
                    if (nl.charAt(i) == ':') {
                        done = true;
                        startingIndex = i + 1;
                    } else {
                        idString += nl.charAt(i);
                    }
                }
                nl = nl.substring(startingIndex);
                String[] games = nl.split(";");
                for (String game : games) {
                    String[] draws = game.split(",");
                    for (String draw : draws) {
                        String[] numAndColor = draw.split(" ");
                        int count = Integer.parseInt(numAndColor[1]);
                        if ((numAndColor[2].equals("red") && count > maxRed) || (numAndColor[2].equals("blue") && count > maxBlue) || (numAndColor[2].equals("green") && count > maxGreen)) {
                            possible = false;
                        }
                    }
                }
                sum += possible ? Integer.parseInt(idString): 0;
            }
            System.out.println(sum + ":) :) :)");
            }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}