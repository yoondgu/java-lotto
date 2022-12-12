package lotto.dto;

public class RankDTO {
    private final int ruleCount;
    private final boolean toMatchBonus;
    private final int prize;
    private final int winningCount;

    public RankDTO(int ruleCount, int prize, int winningCount, boolean toMatchBonus) {
        this.ruleCount = ruleCount;
        this.prize = prize;
        this.winningCount = winningCount;
        this.toMatchBonus = toMatchBonus;
    }

    public int getRuleCount() {
        return ruleCount;
    }

    public int getPrize() {
        return prize;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean isToMatchBonus() {
        return toMatchBonus;
    }
}
