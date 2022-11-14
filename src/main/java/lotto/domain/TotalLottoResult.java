package lotto.domain;

import lotto.domain.constants.LottoRank;
import lotto.domain.constants.LottoRule;

import java.util.Map;

public class TotalLottoResult {
    private final Map<LottoRank, Integer> totalCountOfRankings;

    // TODO 전달받는 Map<LottoRank, Integer>에 대한 유효성 검사 여부, 한다면 예외클래스 무엇인지 검토할 것.
    public TotalLottoResult(Map<LottoRank, Integer> totalCountOfRankings) {
        this.totalCountOfRankings = totalCountOfRankings;
    }

    public double calculateEarningRatio() {
        int totalPrize = addUpTotalPrizeAmount();
        double earningRatio = totalPrize*(100.0)/calculateTotalPurchaseAmount();
        return Math.round(earningRatio*10)/10.0;
    }

    private int calculateTotalPurchaseAmount() {
        return addUpTotalPurchaseCount()*(LottoRule.PRICE.getValue());
    }

    private int addUpTotalPurchaseCount() {
        return totalCountOfRankings.values()
                .stream()
                .reduce(0, Integer::sum);
    }

    private int addUpTotalPrizeAmount() {
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
}
