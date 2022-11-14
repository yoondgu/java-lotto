package lotto.domain;

import lotto.domain.constants.LottoRule;
import lotto.domain.validator.PaymentValidator;

public class MoneyCalculator {
    public static double calculateEarningRatio(int totalPrize, int payment) {
        // TODO 총상금 validate
        PaymentValidator.validatePayment(payment);
        double earningRatio = totalPrize*(100.0)/payment;
        return Math.round(earningRatio*10)/10.0;
    }

    public static int calculateIssueAmountByPayment(int payment) {
        PaymentValidator.validatePayment(payment);
        return payment/(LottoRule.PRICE.getValue());
    }
}
