package lotto.domain;

import lotto.domain.constants.ErrorMessage;
import lotto.domain.constants.LottoRank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TotalLottoResult {
    private final Map<LottoRank, Integer> totalCountOfRankings;

    public TotalLottoResult(Map<LottoRank, Integer> totalCountOfRankings) {
        validateTotalCountOfRankings(totalCountOfRankings);
        this.totalCountOfRankings = totalCountOfRankings;
    }

    public int addUpTotalPrizeAmount() {
        return totalCountOfRankings.keySet()
                .stream()
                .map(this::calculatePrizeByCountedRank)
                .reduce(0,Integer::sum);
    }

    private int calculatePrizeByCountedRank(LottoRank countedRank) {
        int count = totalCountOfRankings.get(countedRank);
        int prize = countedRank.getPrize();
        return count*prize;
    }

    // TODO validator 클래스 분리 여부
    private void validateTotalCountOfRankings(Map<LottoRank, Integer> totalCountOfRankings) {
        if (isRanksIllegal(totalCountOfRankings)) {
            throw new IllegalArgumentException(ErrorMessage.RESULT_RANK_ILLEGAL.getValue());
        }
        if (hasNotCounted(totalCountOfRankings)) {
            throw new IllegalArgumentException(ErrorMessage.RESULT_RANK_NOT_COUNTED.getValue());
        }
    }

    private boolean isRanksIllegal(Map<LottoRank, Integer> totalCountOfRankings) {
        Set<LottoRank> countedRanks = totalCountOfRankings.keySet();
        List<LottoRank> allRanks = Arrays.asList(LottoRank.values());
        if (countedRanks.size() != allRanks.size()) {
            return true;
        }
        return !countedRanks.containsAll(allRanks);
    }

    private boolean hasNotCounted(Map<LottoRank, Integer> totalCountOfRankings) {
        int rankingsCount = totalCountOfRankings.values()
                .stream()
                .reduce(0, Integer::sum);
        return (rankingsCount == 0);
    }
}
