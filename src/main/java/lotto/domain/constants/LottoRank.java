package lotto.domain.constants;

public enum LottoRank {
    RANK_1(6, false, 2_000_000_000),
    RANK_2(5,true, 30_000_000),
    RANK_3(5, false, 1_500_000),
    RANK_4(4, false, 50_000),
    RANK_5(3, false, 5_000),
    RANK_LOSE(0,false, 0)
    ;

    private final int requiredMatchCount;
    private final boolean requiredToCheckBonus;
    private final int prize;

    private LottoRank(int requiredMatchCount, boolean requiredToCheckBonus, int prize) {
        this.requiredMatchCount = requiredMatchCount;
        this.requiredToCheckBonus = requiredToCheckBonus;
        this.prize = prize;
    }

    public boolean requiredToCheckBonus() {
        return requiredToCheckBonus;
    }

    public boolean hasSameMatchCount(int matchCount) {
        return matchCount == requiredMatchCount;
    }

    public int getPrize() {
        return prize;
    }
}
