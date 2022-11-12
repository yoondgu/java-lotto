package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.constants.ErrorMessage;
import lotto.domain.constants.LottoRule;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    public static List<Lotto> issueLottosByAmount(int amount) {
        validateIssueAmount(amount);
        List<Lotto> purchasedLottos = new ArrayList<>();
        while (purchasedLottos.size() < amount) {
            List<Integer> randomNumbers = generateLottoNumbersByRandom();
            purchasedLottos.add(new Lotto(randomNumbers));
        }
        return purchasedLottos;
    }

    public static int calculateIssueAmountByPayment(int payment) {
        validatePayment(payment);
        return payment/(LottoRule.PRICE.getValue());
    }

    private static void validateIssueAmount(int amount) {
        // TODO 예외클래스, 에러메시지 처리 적절한지 검토
        if (amount < 1) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_ZERO_COUNT.getValue());
        }
    }

    private static void validatePayment(int payment) {
        if(payment < 0) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_NEGATIVE.getValue());
        }

        int lottoPrice = LottoRule.PRICE.getValue();
        if (payment < lottoPrice) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_ZERO_COUNT.getValue());
        }
        if (payment%(lottoPrice) != 0) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_HAS_REMAINDER.getValue());
        }
    }

    private static List<Integer> generateLottoNumbersByRandom() {
        int startInclusive = LottoRule.MINIMUM_NUMBER.getValue();
        int endInclusive = LottoRule.MAXIMUM_NUMBER.getValue();
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive,6);
    }
}
