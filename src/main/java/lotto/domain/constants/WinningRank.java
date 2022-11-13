package lotto.domain.constants;

public enum WinningRank {
    RANK_1(1, 6, false),
    RANK_2(2, 5,true),
    RANK_3(3, 5, false),
    RANK_4(4, 4, false),
    RANK_5(5, 3, false),
    RANK_NOTHING(-1, 0,false)
    ;

    private final int value;
    private final int requiredMatchCount;
    private final boolean requiredToCheckBonus;

    private WinningRank(int value, int requiredMatchCount, boolean requiredToCheckBonus) {
        this.value = value;
        this.requiredMatchCount = requiredMatchCount;
        this.requiredToCheckBonus = requiredToCheckBonus;
    }

    public int getValue() {
        return value;
    }

    public boolean requiredToCheckBonus() {
        return requiredToCheckBonus;
    }

    public boolean hasSameMatchCount(int matchCount) {
        if (matchCount == requiredMatchCount) {
            return true;
        }
        return false;
    }
}
