package lotto.domain;

import lotto.domain.constants.WinningRank;
import lotto.domain.validator.LottoNumbersValidator;

public class LottoDraw {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoDraw(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        LottoNumbersValidator.validateLottoDrawNumbers(winningLotto, bonusNumber);
    }

    private int calculateRankingByPurchasedLotto(Lotto purchasedLotto) {
        for (WinningRank rank : WinningRank.values()) {
            if (isRightRanking(rank, purchasedLotto)) {
                return rank.getValue();
            }
        }
        return WinningRank.RANK_NOTHING.getValue();
    }

    private boolean isRightRanking(WinningRank rank, Lotto purchasedLotto) {
        int matchCount = winningLotto.countMatchingNumbers(purchasedLotto);
        if (rank.hasSameMatchCount(matchCount) && rank.requiredToCheckBonus()) {
            return purchasedLotto.containsThisNumber(bonusNumber);
        }
        return rank.hasSameMatchCount(matchCount);
    }
}
