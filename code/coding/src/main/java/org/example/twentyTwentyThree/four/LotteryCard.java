package org.example.twentyTwentyThree.four;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LotteryCard {
    private int gameNum;
    private int originalWins;
    private int numOfCards;

    public LotteryCard(int gameNum, int originalWins) {
        this.gameNum = gameNum;
        this.originalWins = originalWins;
    }

    @Override
    public String toString() {
        return "LotteryCard{" +
                "gameNum=" + gameNum +
                ", originalWins=" + originalWins +
                ", numOfCards=" + numOfCards +
                '}';
    }
}
