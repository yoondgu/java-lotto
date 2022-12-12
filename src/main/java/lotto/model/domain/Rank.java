package lotto.model.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Rank {
    FIRST(6, (matchCount, hasBonusNumber) -> matchCount == 6, 2_000_000_000),
    SECOND(5, (matchCount, hasBonusNumber) -> (matchCount == 5) && hasBonusNumber, 30_000_000),
    THIRD(5, (matchCount, hasBonusNumber) -> (matchCount == 5) && !hasBonusNumber, 15_000_000),
    FOURTH(4, (matchCount, hasBonusNumber) -> matchCount == 4, 50_000),
    FIFTH(3, (matchCount, hasBonusNumber) -> matchCount == 3, 5_000);

    private final int matchingCount;
    private final BiFunction<Integer, Boolean, Boolean> matchingResult;
    private final int prize;

    Rank(int matchingCount, BiFunction<Integer, Boolean, Boolean> matchingResult, int prize) {
        this.matchingCount = matchingCount;
        this.matchingResult = matchingResult;
        this.prize = prize;
    }

    public static Rank findRank(int matchCount, boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> rank.isRightRank(matchCount, hasBonusNumber))
                .findFirst()
                .orElse(null);
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }

    private boolean isRightRank(int matchCount, boolean hasBonusNumber) {
        return matchingResult.apply(matchCount, hasBonusNumber);
    }
}
