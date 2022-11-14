package lotto.domain;

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

    private void validateTotalCountOfRankings(Map<LottoRank, Integer> totalCountOfRankings) {
        if (hasRankNotCounted(totalCountOfRankings)) {
            // TODO 에러메시지 작성
            throw new IllegalArgumentException("");
        }
        if (isTotalCountZero(totalCountOfRankings)) {
            // TODO 에러메시지 작성
            throw new IllegalArgumentException("");
        }
    }

    private boolean hasRankNotCounted(Map<LottoRank, Integer> totalCountOfRankings) {
        Set<LottoRank> countedRanks = totalCountOfRankings.keySet();
        List<LottoRank> allRanks = Arrays.asList(LottoRank.values());
        if (countedRanks.size() != allRanks.size()) {
            return true;
        }
        return !countedRanks.containsAll(allRanks);
    }

    private boolean isTotalCountZero(Map<LottoRank, Integer> totalCountOfRankings) {
        int rankingsCount = totalCountOfRankings.values()
                .stream()
                .reduce(0, Integer::sum);
        return (rankingsCount == 0);
    }
}
