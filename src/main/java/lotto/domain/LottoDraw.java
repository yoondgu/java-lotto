package lotto.domain;

import lotto.domain.constants.LottoRank;
import lotto.domain.validator.LottoNumbersValidator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<LottoRank, Integer> sumUpCountOfRankings(List<Lotto> purchasedLottos) {
        Map<LottoRank, Integer> totalCountOfRankings = initializeCountOfRankings();
        purchasedLottos.stream()
                .map(this::calculateRankingByPurchasedLotto)
                .forEach(ranking -> addOneToCountOfRankings(totalCountOfRankings, ranking));
        return totalCountOfRankings;
    }

    private Map<LottoRank, Integer> initializeCountOfRankings() {
        Map<LottoRank, Integer> totalCountOfRankings = new HashMap<>();
        Arrays.stream(LottoRank.values())
                .forEach(rankValue -> totalCountOfRankings.put(rankValue, 0));
        return totalCountOfRankings;
    }

    private void addOneToCountOfRankings(Map<LottoRank, Integer> totalCountOfRankings, LottoRank ranking) {
        int count = totalCountOfRankings.getOrDefault(ranking, 0) + 1;
        totalCountOfRankings.put(ranking, count);
    }

    private LottoRank calculateRankingByPurchasedLotto(Lotto purchasedLotto) {
        for (LottoRank rank : LottoRank.values()) {
            if (isRightRanking(rank, purchasedLotto)) {
                return rank;
            }
        }
        return LottoRank.RANK_LOSE;
    }

    private boolean isRightRanking(LottoRank rank, Lotto purchasedLotto) {
        int matchCount = winningLotto.countMatchingNumbers(purchasedLotto);
        if (rank.hasSameMatchCount(matchCount) && rank.requiredToCheckBonus()) {
            return purchasedLotto.containsThisNumber(bonusNumber);
        }
        return rank.hasSameMatchCount(matchCount);
    }
}
