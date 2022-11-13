package lotto.domain.constants;

public enum LottoRank {
    RANK_1(6, false),
    RANK_2(5,true),
    RANK_3(5, false),
    RANK_4(4, false),
    RANK_5(3, false),
    RANK_LOSE(0,false)
    ;

    private final int requiredMatchCount;
    private final boolean requiredToCheckBonus;

    private LottoRank(int requiredMatchCount, boolean requiredToCheckBonus) {
        this.requiredMatchCount = requiredMatchCount;
        this.requiredToCheckBonus = requiredToCheckBonus;
    }

    public boolean requiredToCheckBonus() {
        return requiredToCheckBonus;
    }

    public boolean hasSameMatchCount(int matchCount) {
        return matchCount == requiredMatchCount;
    }
}
