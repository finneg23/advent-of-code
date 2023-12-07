package org.example.twentyTwentyThree.three;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
    public static void main (String[] args) {
        //bring in the file
        File inputFile = new File("C:\\Users\\conno\\workspace\\advent-code-challenges\\code\\coding\\src\\main\\java\\org\\example\\resources\\twentyTwentyThree\\three.txt");

        try {
            //scan the file
            Scanner scanner = new Scanner(inputFile);
            //load the file data to an arraylist
            List<String> dater = new ArrayList<>();
            while (scanner.hasNextLine()) {
                dater.add(scanner.nextLine());
            }
            //make it an array for easy indexing
            String[] engineInputLines = dater.toArray(new String[0]);
            //set up a sum to add to
             int sum = 0;
            //iterate through all the strings
            for (int i = 0; i < engineInputLines.length; i++) {
            //print the line before modifying it
                //System.out.println(i > 0 ?engineInputLines[i - 1] : "start");
                //set up three strings, one for the current line, one for the previous, one for the next line
                String previousLine = i == 0 ? "" : engineInputLines[i-1];
                String currentLine = engineInputLines[i];
                String nextLine = i == engineInputLines.length-1 ? "" : engineInputLines[i + 1];
                //iterate through the current string
                for (int j = 0; j < currentLine.length(); j++) {
                    switch (currentLine.charAt(j)) {
                        case '/':
                        case '#':
                        case '-':
                        case '*':
                        case '%':
                        case '=':
                        case '&':
                        case '@':
                        case '$':
                        case '+':
                            //check on this line behind the symbol
                            String num = "";
                            for (int k = j - 1; Character.isDigit(currentLine.charAt(k)); k--) {
                                num = currentLine.charAt(k) + num;
                                char[] editableLine = currentLine.toCharArray();
                                editableLine[k] = '.';
                                String assignable = new String (editableLine);
                                engineInputLines[i] = assignable;
                                currentLine = engineInputLines[i];
                            }
                            sum += !num.isEmpty() ? Integer.parseInt(num) : 0;
                            //check on this line ahead of the symbol
                            num = "";
                            for (int k = j + 1; Character.isDigit(currentLine.charAt(k)); k++) {
                                num += currentLine.charAt(k);
                                char[] editableLine = currentLine.toCharArray();
                                editableLine[k] = '.';
                                String assignable = new String (editableLine);
                                engineInputLines[i] = assignable;
                                currentLine = engineInputLines[i];
                            }
                            sum += !num.isEmpty() ? Integer.parseInt(num) : 0;
                            //check the 7 characters above the symbol
                            num = "";
                            for (int k = j - 3; k <= j + 3; k++) {
                                if (Character.isDigit(previousLine.charAt(k))) {
                                    if (num.isEmpty() && k > j + 1) {
                                        continue;
                                    } else {
                                        num += previousLine.charAt(k);
                                    }
                                } else if (!num.isEmpty()) {
                                    if (k < j) {
                                        num = "";
                                    } else {
                                        if (k == j + 3 && num.length() < 2) {
                                            num = "";
                                        } else {sum += Integer.parseInt(num);
                                                engineInputLines[i - 1] = engineInputLines[i - 1].replace(num, num.length() == 1 ? "." : num.length() == 2 ? ".." : "...");
                                                num = "";}
                                    }
                                }
                            }
                            if (!num.isEmpty()) {
                                sum += num.length() > 1 ? Integer.parseInt(num) : 0;
                                engineInputLines[i - 1] = engineInputLines[i - 1].replace(num, num.length() == 1 ? "." : num.length() == 2 ? ".." : "...");
                            }

                            //check the 7 characters below the symbol
                            num = "";
                            for (int k = j - 3; k <= j + 3; k++) {
                                if (Character.isDigit(nextLine.charAt(k))) {
                                    if (num.isEmpty() && k > j + 1) {
                                        continue;
                                    } else {
                                        num += nextLine.charAt(k);
                                    }
                                } else if (!num.isEmpty()) {
                                    if (k < j) {
                                        num = "";
                                    } else {
                                        if (k == j + 3 && num.length() < 2) {
                                            num = "";
                                        } else {sum += Integer.parseInt(num);
                                            engineInputLines[i + 1] = engineInputLines[i + 1].replace(num, num.length() == 1 ? "." : num.length() == 2 ? ".." : "...");
                                            num = "";}
                                    }
                                }
                            }
                            if (!num.isEmpty()) {
                                sum += num.length() > 1 ? Integer.parseInt(num) : 0;
                                engineInputLines[i + 1] = engineInputLines[i + 1].replace(num, num.length() == 1 ? "." : num.length() == 2 ? ".." : "...");
                            }
                    }
                }
                //System.out.println(sum);
            }
            for (String line : engineInputLines) {
                System.out.println(line);
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        timesTabler(3);
    }



    public static void timesTabler(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1;j <= n; j++) {
                System.out.println(j * i);
            }
        }
    }


}


