package org.example.twentyTwentyThree.four;

public class random {

    public static void main (String[] args) {
        int n = 50;
        String basePadding = "   ";
        for (int i = 0; i <= String.valueOf(n * n).length(); i++) {
            basePadding += "  ";
        }
        for (int i = 1; i <= n; i++ ) {
            System.out.println();
            for (int j = 1; j <= n; j++) {

                System.out.print(i * j + basePadding);
            }
        }
    }
}
