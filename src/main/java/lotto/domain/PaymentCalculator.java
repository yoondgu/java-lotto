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
        double earningRatio = totalPrize*(100.0)/payment;
        return Math.round(earningRatio*10)/10.0;
    }

    public int calculateIssueAmountByPayment() {
        return payment/(LottoRule.PRICE.getValue());
    }
}
