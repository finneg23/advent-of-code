package org.example.twentyTwentyThree.four;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {
    public static void main (String[] args) {
        Scanner scanner = getFileAndScan("C:\\Users\\conno\\workspace\\advent-code-challenges\\code\\coding\\src\\main\\java\\org\\example\\resources\\twentyTwentyThree\\four.txt");
        List<String> sheets = new ArrayList<>();
        List<LotteryCard> lotteryCardList = new ArrayList<>();
        int gameNum = 0;
        while (scanner.hasNextLine()) {
            sheets.add(scanner.nextLine());
        }


        String[] separateSheets = breakIntoWinningAndLosing(sheets).toArray(new String[0]);

        List<String> winningNums = new ArrayList<>();
        List<String> checkAgainstNums = new ArrayList<>();

        separateOutToIntLists(separateSheets, winningNums, checkAgainstNums);

        for (String str: winningNums) {
            //System.out.println(str);
        }

        for (String str: checkAgainstNums) {
            //System.out.println(str);
        }

        int sum = 0;

        for (int i = 0; i < checkAgainstNums.size(); i++) {
            int pts = getPts(winningNums, i, checkAgainstNums);
            sum += pts;
            int counter = 0;
            //System.out.println(pts);
            while (pts > 0) {
                counter++;
                pts /= 2;
            }
            gameNum++;
            System.out.println(gameNum + " - - - - - " + counter);
            lotteryCardList.add(new LotteryCard(gameNum, counter));
        }

        int totalCards = calculateTicketTotal(lotteryCardList);
        System.out.println(totalCards);
        System.out.println(sum);
    }

    public static int calculateTicketTotal(List<LotteryCard> list) {
        for (int i = 0; i < list.size(); i++) {
            LotteryCard card = list.get(i);
            for (int copies = 0; copies <= card.getNumOfCards(); copies++) {
                for (int wins = 1; wins <= card.getOriginalWins(); wins++) {
                    LotteryCard cardToAddWins = list.get(i + wins);
                    cardToAddWins.setNumOfCards(cardToAddWins.getNumOfCards() + 1);
                }
            }
        }
        int total = 0;
        for (LotteryCard card : list) {
            total += card.getNumOfCards() + 1;
        }
        return total;
    }

    private static int getPts(List<String> winningNums, int i, List<String> checkAgainstNums) {
        String[] splitWinners = winningNums.get(i).split(" ");
        String[] splitPossibilities = checkAgainstNums.get(i).split(" ");
        int pts = 0;
        for (int j = 0; j < splitPossibilities.length; j++) {
            for (int k = 0; k < splitWinners.length; k++) {
                pts = (!splitWinners[k].isEmpty() && splitPossibilities[j].equals(splitWinners[k]) && pts == 0) ? 1 :
                        (!splitWinners[k].isEmpty() && splitPossibilities[j].equals(splitWinners[k])) ? pts * 2 : pts;
            }
        }
        return pts;
    }

    public static Scanner getFileAndScan(String filePath) {
        File inputFile = new File(filePath);
        try {
            return new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> breakIntoWinningAndLosing(List<String> sheets) {
        List<String> brokenUpSheets = new ArrayList<>();
        for (String sheet : sheets) {
            String[] brokenUpSheet = sheet.split("\\|");
            brokenUpSheets.add(brokenUpSheet[0]);
            brokenUpSheets.add(brokenUpSheet[1]);
        }

        for (int i = 0; i <brokenUpSheets.size(); i++) {
            if (brokenUpSheets.get(i).startsWith("Card")) {
                brokenUpSheets.set(i, brokenUpSheets.get(i).substring(10));
            }
        }
        return brokenUpSheets;
    }

    public static void separateOutToIntLists(String[] separateSheets, List<String> list1, List<String> list2) {
        for (int i = 0; i < separateSheets.length; i++) {
            if ((i % 2) == 0) {
                list1.add(separateSheets[i]);
            } else {
                list2.add(separateSheets[i]);
            }
        }
    }
}
