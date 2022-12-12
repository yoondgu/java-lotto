package lotto.model.domain;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean toMatchBonus;
    private final int prize;

    Rank(int matchCount, boolean toMatchBonus, int prize) {
        this.matchCount = matchCount;
        this.toMatchBonus = toMatchBonus;
        this.prize = prize;
    }

    public static Rank findRank(int matchCount, boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> rank.isRightRank(matchCount, hasBonusNumber))
                .findFirst()
                .orElse(null);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isToMatchBonus() {
        return toMatchBonus;
    }

    private boolean isRightRank(int matchedCount, boolean hasBonusNumber) {
        boolean hasSameMatchCount = matchedCount == this.matchCount;
        if (hasBonusNumber) {
            return hasSameMatchCount && toMatchBonus;
        }
        return hasSameMatchCount;
    }
}
