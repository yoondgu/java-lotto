package lotto.domain;

import lotto.domain.constants.LottoRule;
import lotto.domain.validator.MoneyValidator;

public class PaymentCalculator {
    private final int payment;

    public PaymentCalculator(int payment) {
        MoneyValidator.validatePayment(payment);
        this.payment = payment;
    }
    public double calculateEarningRatio(int totalPrize) {
        MoneyValidator.validateTotalPrize(totalPrize);
        return totalPrize*(100.0)/payment;
    }

    public int calculateIssueAmountByPayment() {
        return payment/(LottoRule.PRICE.getValue());
    }
}
