package lotto.model.domain;

import java.util.List;
import java.util.Objects;
import lotto.model.constants.ErrorMessage;
import lotto.model.constants.LottoRule;

public class LottoDraw {
    private final Lotto drawNumbers;
    private final int bonusNumber;

    public LottoDraw(List<Integer> drawNumbers, int bonusNumber) {
        validate(drawNumbers, bonusNumber);
        this.drawNumbers = new Lotto(drawNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> drawNumbers, int bonusNumber) {
        if (bonusNumber < LottoRule.LOTTO_MIN_NUMBER || bonusNumber > LottoRule.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INVALID_BONUS_NUMBER);
        }
        if (drawNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATED_BONUS_NUMBER);
        }
    }

    public RankCount computeAllResult(List<Lotto> purchasedLottos) {
        RankCount rankCount = new RankCount();
        purchasedLottos.stream()
                .map(lotto -> Rank.findRank(getMatchingCount(lotto), lotto.contains(bonusNumber)))
                .filter(Objects::nonNull)
                .forEach(rankCount::addCount);
        return rankCount;
    }

    private int getMatchingCount(Lotto lotto) {
        return (int) drawNumbers.getNumbers()
                .stream()
                .filter(lotto::contains)
                .count();
    }
}
