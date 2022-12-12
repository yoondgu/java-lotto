package lotto.model.domain;

import java.util.List;
import lotto.model.constants.ErrorMessage;
import lotto.model.constants.LottoRule;

public class LottoDraw {
    private final Lotto drawNumbers;
    private final int bonusNumber;

    public LottoDraw(List<Integer> drawNumbers, int bonusNumber) {
        validate(drawNumbers, bonusNumber);
        this.drawNumbers = new Lotto(drawNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> drawNumbers, int bonusNumber) {
        if (bonusNumber < LottoRule.LOTTO_MIN_NUMBER || bonusNumber > LottoRule.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INVALID_BONUS_NUMBER);
        }
        if (drawNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATED_BONUS_NUMBER);
        }
    }
}
