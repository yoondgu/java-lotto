package lotto.model.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.dto.RankDTO;

public class RankCount {
    private final Map<Rank, Integer> rankCount;

    public RankCount(Map<Rank, Integer> rankCount) {
        this.rankCount = rankCount;
    }

    public double computeProfitRate(int purchaseAmount) {
        return sumTotalPrize() * 100.0 / purchaseAmount;
    }

    private int sumTotalPrize() {
        return rankCount.keySet()
                .stream().map(rank -> (rank.getPrize()) * (rankCount.get(rank)))
                .reduce(0, Integer::sum);
    }

    public List<RankDTO> of() {
        return rankCount.keySet()
                .stream()
                .map(rank -> new RankDTO(rank.getMatchingCount(), rank.getPrize(), rankCount.get(rank)))
                .collect(Collectors.toList());
    }
}
