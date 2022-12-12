package lotto.model.domain;

import java.util.Map;

public class RankCount {
    private final Map<Rank, Integer> rankCount;

    public RankCount(Map<Rank, Integer> rankCount) {
        this.rankCount = rankCount;
    }
}
