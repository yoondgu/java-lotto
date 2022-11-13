package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    // TODO LottoTest와 같은 Validator 메소드를 사용하기 때문에 테스트 내용이 겹치는 것 상관 없는지?
    @DisplayName("추첨 번호의 개수가 6개가 넘어가면 예외가 발생")
    @Test
    void createWinningNumbersByOverSize() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("추첨 번호에 중복된 숫자가 있으면 예외가 발생")
    @Test
    void createWinningNumbersByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("추첨 번호에 범위 밖의 숫자가 있으면 예외가 발생")
    @Test
    void createWinningNumbersByOutOfBoundsNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 50), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위 밖의 숫자이면 예외가 발생")
    @Test
    void createWinningNumbersByOutOfBoundsBonus() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 이미 추첨 번호에 존재하면 예외가 발생")
    @Test
    void createWinningNumbersByDuplicatedBonus() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}