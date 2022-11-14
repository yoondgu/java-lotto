package lotto.domain.validator;

import lotto.domain.constants.ErrorMessage;
import lotto.domain.constants.LottoRule;

public class PaymentValidator {
    public static void validatePayment(int payment) {
        if(isNegative(payment)) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_NEGATIVE.getValue());
        }
        if (isLessThanLottoPrice(payment)) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_ZERO_COUNT.getValue());
        }
        if (hasRemainderForLottoPrice(payment)) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_HAS_REMAINDER.getValue());
        }
    }

    private static boolean isNegative(int payment)  {
        return payment < 0;
    }

    private static boolean isLessThanLottoPrice(int payment) {
        return payment < LottoRule.PRICE.getValue();
    }

    private static boolean hasRemainderForLottoPrice(int payment) {
        return payment%(LottoRule.PRICE.getValue()) != 0;
    }
}
