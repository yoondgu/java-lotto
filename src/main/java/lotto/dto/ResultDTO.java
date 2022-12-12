package lotto.dto;

import java.util.List;

public class ResultDTO {
    private final List<RankDTO> rankCount;
    private final double profitRate;

    public ResultDTO(List<RankDTO> rankCount, double profitRate) {
        this.rankCount = rankCount;
        this.profitRate = profitRate;
    }
}
