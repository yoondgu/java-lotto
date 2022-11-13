package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
}