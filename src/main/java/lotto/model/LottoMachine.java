package lotto.model;

import static lotto.model.constants.LottoRule.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.model.constants.ErrorMessage;
import lotto.model.domain.Lotto;

public class LottoMachine {
    private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    public List<Lotto> issueLottos(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int quantity = computeIssueQuantity(purchaseAmount);
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < quantity) {
            lottos.add(new Lotto(lottoNumberGenerator.generate()));
        }
        return lottos;
    }

    private int computeIssueQuantity(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_INVALID_VALUE);
        }
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_INVALID_VALUE);
        }
    }
}
