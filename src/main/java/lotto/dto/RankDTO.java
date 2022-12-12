package lotto.dto;

public class RankDTO {
    private final int ruleCount;
    private final int prize;
    private final int winningCount;

    public RankDTO(int ruleCount, int prize, int winningCount) {
        this.ruleCount = ruleCount;
        this.prize = prize;
        this.winningCount = winningCount;
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
}
