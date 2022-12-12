package lotto.dto;

public class RankDTO {
    private final int matchCount;
    private final int prize;
    private final int count;

    public RankDTO(int matchCount, int prize, int count) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.count = count;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }
}
