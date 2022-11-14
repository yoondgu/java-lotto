package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoSellerTest {
    @DisplayName("발행한 로또 개수와 주어진 개수 일치 여부 테스트")
    @Test
    void issueLottosByAmount() {
        int amount = 7;
        assertThat(LottoSeller.issueLottosByAmount(amount))
                .isNotNull()
                .isInstanceOf(List.class)
                .hasSize(amount);
    }

    @DisplayName("발행할 로또 개수가 1보다 작으면 예외가 발생")
    @Test
    void issueLottosByAmountLessThan1() {
        assertThatThrownBy(() -> LottoSeller.issueLottosByAmount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.AMOUNT_INSUFFICIENT.getValue());
    }
}