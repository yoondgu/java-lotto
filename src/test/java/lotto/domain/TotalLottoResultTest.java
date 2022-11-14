package lotto.domain;

import lotto.domain.constants.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class TotalLottoResultTest {
    private final Map<LottoRank, Integer> totalCountOfRanking = new HashMap<>(Map.of(
            LottoRank.RANK_1, 0, LottoRank.RANK_2, 0,
            LottoRank.RANK_3, 0, LottoRank.RANK_4, 0,
            LottoRank.RANK_5, 2, LottoRank.RANK_LOSE, 4)
            );
    private final TotalLottoResult result = new TotalLottoResult(totalCountOfRanking);

    @DisplayName("계산한 수익률은 소수점 둘째자리에서 반올림")
    @Test
    void calculateEarningRatioRoundedUpToSecondDigit() {
        assertThat(result.calculateEarningRatio()).isEqualTo(166.7);
    }
}