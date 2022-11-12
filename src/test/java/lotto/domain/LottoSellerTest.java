package lotto.domain;

import lotto.domain.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoSellerTest {
    @DisplayName("구입 금액이 음수이면 예외가 발생")
    @Test
    void calculateIssueCountsByNegative() {
        assertThatThrownBy(() -> LottoSeller.calculateIssueCountsByPayment(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PAYMENT_NEGATIVE.getValue());
    }

    @DisplayName("구입 금액이 양수이지만 1,000보다 작으면 예외가 발생")
    @Test
    void calculateIssueCountsToZero() {
        assertThatThrownBy(() -> LottoSeller.calculateIssueCountsByPayment(900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PAYMENT_ZERO_COUNT.getValue());
    }

    @DisplayName("구입 금액이 1,000보다 크지만 나머지가 존재하면 예외가 발생")
    @Test
    void calculateIssueCountsByHavingRemainder() {
        assertThatThrownBy(() -> LottoSeller.calculateIssueCountsByPayment(1200))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PAYMENT_HAS_REMAINDER.getValue());
    }
}