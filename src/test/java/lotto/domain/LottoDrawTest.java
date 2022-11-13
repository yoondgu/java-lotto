package lotto.domain;

import lotto.domain.constants.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoDrawTest {
    Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("보너스 번호가 범위 밖의 숫자이면 예외가 발생")
    @Test
    void createLottoDrawByOutOfBoundsBonusNumber() {
        assertThatThrownBy(() -> new LottoDraw(winningLotto, 50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 이미 추첨 번호에 존재하면 예외가 발생")
    @Test
    void createLottoDrawByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new LottoDraw(winningLotto, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 등수의 개수 합산 시 0개인 등수도 모두 저장")
    @Test
    void sumUpCountOfAllRankingsIncludingZero() {
        List<Lotto> purchasedLottos = LottoSeller.issueLottosByAmount(10);
        Map<LottoRank, Integer> totalCountOfRankings = new LottoDraw(winningLotto, 7).sumUpCountOfRankings(purchasedLottos);
        assertThat(totalCountOfRankings.keySet()).containsExactlyInAnyOrder(LottoRank.values());
    }

    @DisplayName("당첨 등수의 개수 합산 시 낙첨인 경우도 개수를 저장")
    @Test
    void sumUpCountOfAllRankingsIncludingLose() {
        int lottosCount = 10;
        List<Lotto> purchasedLottos = LottoSeller.issueLottosByAmount(lottosCount);
        Map<LottoRank, Integer> totalCountOfRankings = new LottoDraw(winningLotto, 7).sumUpCountOfRankings(purchasedLottos);
        int sumOfCount = totalCountOfRankings.values()
                .stream()
                .reduce(0, Integer::sum);
        assertThat(sumOfCount).isEqualTo(lottosCount);
    }
}