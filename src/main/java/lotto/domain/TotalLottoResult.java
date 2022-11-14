package lotto.domain;

import lotto.domain.constants.LottoRank;
import lotto.domain.constants.LottoRule;

import java.util.Map;

public class TotalLottoResult {
    private final Map<LottoRank, Integer> totalCountsOfRank;

    // TODO 전달받는 Map<LottoRank, Integer>에 대한 유효성 검사 여부, 한다면 예외클래스 무엇인지 검토할 것.
    public TotalLottoResult(Map<LottoRank, Integer> totalCountsOfRank) {
        this.totalCountsOfRank = totalCountsOfRank;
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
        return totalCountsOfRank.values()
                .stream()
                .reduce(0, Integer::sum);
    }

    private int addUpTotalPrizeAmount() {
        return totalCountsOfRank.keySet()
                .stream()
                .map(this::calculatePrizeByCountedRank)
                .reduce(0,Integer::sum);
    }

    private int calculatePrizeByCountedRank(LottoRank countedRank) {
        int count = totalCountsOfRank.get(countedRank);
        int prize = countedRank.getPrize();
        return count*prize;
    }

}
