package org.example.twentyFifteen.two;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Part1 {
    public static void main(String[] args) {
        File inputFile = new File("C:\\Users\\conno\\workspace\\advent-code-challenges\\code\\coding\\src\\main\\java\\org\\example\\resources\\two.txt");
        int total = 0;
        int totalPaper = 0;
        int ribbonNeeded = 0;
        try {
            Scanner input = new Scanner(inputFile);
//            while (input.hasNext()) {
//                String [] dimensions = input.nextLine().split("x");
//                int [] dimens = new int[dimensions.length];
//                for (int i = 0; i < dimensions.length; i++) {
//                    dimens[i] = Integer.parseInt(dimensions[i]);
//                }
//                int paper =     (dimens[0] * dimens[1] * 2) + (dimens[1] * dimens[2] * 2) + (dimens[0] * dimens[2] * 2);
//                paper +=        (dimens[0] * dimens[1]) < (dimens[1] * dimens[2]) && (dimens[0] * dimens[1]) < (dimens[0] * dimens[2]) ? (dimens[0] * dimens[1]) :
//                                (dimens[1] * dimens[2]) < (dimens[0] * dimens[1]) && (dimens[1] * dimens[2]) < (dimens[0] * dimens[2]) ? (dimens[1] * dimens[2]) :
//                                (dimens[0] * dimens[2]);
//                System.out.println(paper);
//                total += paper;
//
//            }
//            System.out.println(total);

            while (input.hasNext()) {
                String[] dimensions = input.nextLine().split("x");
                ArrayList<Integer> dimensionList = new ArrayList<>();
                for (String num : dimensions) {
                    dimensionList.add(Integer.parseInt(num));
                }
                Collections.sort(dimensionList);
                int side1 = dimensionList.get(0) * dimensionList.get(1);
                int side2 = dimensionList.get(1) * dimensionList.get(2);
                int side3 = dimensionList.get(0) * dimensionList.get(2);
                int paperNeeded = (side1 * 2) + (side2 * 2) + (side3 * 2) + side1;
                totalPaper += paperNeeded;
                int ribbon = (dimensionList.get(0) * 2) + (dimensionList.get(1) * 2) + (dimensionList.get(0) * dimensionList.get(1) * dimensionList.get(2));
                ribbonNeeded += ribbon;
            }
            System.out.println(totalPaper + "********");
            System.out.println("*************" + ribbonNeeded);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
