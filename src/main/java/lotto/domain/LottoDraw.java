package lotto.domain;

import lotto.domain.validator.LottoNumbersValidator;

public class LottoDraw {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoDraw(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        LottoNumbersValidator.validateLottoDrawNumbers(winningLotto, bonusNumber);
    }
}
