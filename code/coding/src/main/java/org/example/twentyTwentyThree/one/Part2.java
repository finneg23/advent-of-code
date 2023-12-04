package org.example.twentyTwentyThree.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {
    public static void main (String[] args) {
        File inputFile = new File("C:\\Users\\conno\\workspace\\advent-code-challenges\\code\\coding\\src\\main\\java\\org\\example\\resources\\twentyTwentyThree\\one.txt");
        try {
            Scanner scanner = new Scanner(inputFile);
            int sum = 0;
            while (scanner.hasNextLine()) {
                char[] nl = scanner.nextLine().toCharArray();
                String printable = "";
                for (int i = 0; i < nl.length; i++) {
                    switch (nl[i]) {
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                        case '0':
                            printable += nl[i];
                            break;
                        case 'o':
                            if ((i < nl.length - 2) && (nl[i + 1] == 'n') && (nl[i + 2] == 'e')) {
                               printable += '1';
                            }
                            break;
                        case 't':
                            if ((i < nl.length - 4) && (nl[i + 1] == 'h') && (nl[i + 2] == 'r') && (nl[i + 3] == 'e') && (nl[i + 4] == 'e')) {
                                printable += '3';
                            } else if ((i < nl.length - 2) && (nl[i + 1] == 'w') && (nl[i + 2] == 'o')) {
                                printable += '2';
                            }
                            break;
                        case 'f':
                            if ((i < nl.length - 3) && (nl[i + 1] == 'o') && (nl[i + 2] == 'u') && (nl[i + 3] == 'r')) {
                                printable += '4';
                            } else if ((i < nl.length - 3) && (nl[i + 1] == 'i') && (nl[i + 2] == 'v') && (nl[i + 3] == 'e')) {
                                printable += '5';
                            }
                            break;
                        case 's':
                            if ((i < nl.length - 4) && (nl[i + 1] == 'e') && (nl[i + 2] == 'v') && (nl[i + 3] == 'e') && (nl[i + 4] == 'n')) {
                                printable += '7';
                            } else if ((i < nl.length - 2) && (nl[i + 1] == 'i') && (nl[i + 2] == 'x')) {
                                printable += '6';
                            }
                            break;
                        case 'e':
                            if ((i < nl.length - 4) && (nl[i + 1] == 'i') && (nl[i + 2] == 'g') && (nl[i + 3] == 'h') && (nl[i + 4] == 't')) {
                                printable += '8';
                            }
                            break;
                        case 'n':
                            if ((i < nl.length - 3) && (nl[i + 1] == 'i') && (nl[i + 2] == 'n') && (nl[i + 3] == 'e')) {
                                printable += '9';
                            }
                            break;
                    }
                }
                System.out.println(printable);
                if(printable.length() < 2) {
                    printable = printable + printable;
                } else {
                    printable = printable.substring(0, 1) + printable.substring(printable.length()-1);
                }
                System.out.println(printable);
                sum += Integer.parseInt(printable);
            }
            System.out.println("Yay! " + sum);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
