package lotto.domain.validator;

import lotto.domain.Lotto;
import lotto.domain.constants.ErrorMessage;
import lotto.domain.constants.LottoRule;

import java.util.List;

public class LottoNumbersValidator {
    public static void validateLottoDrawNumbers(Lotto winningLotto, int bonusNumber) {
        if (isOutOfBounds(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_OUT_OF_BOUNDS.getValue());
        }
        if (winningLotto.containsThisNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATED.getValue());
        }
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        if (hasInvalidSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INVALID_SIZE.getValue());
        }
        if (containsOutOfBoundsNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_OUT_OF_BOUNDS.getValue());
        }
        if (containsDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATED.getValue());
        }
    }

    private static boolean hasInvalidSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LottoRule.NUMBERS_COUNT.getValue()) {
            return true;
        }
        return false;
    }

    private static boolean containsOutOfBoundsNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .anyMatch(LottoNumbersValidator::isOutOfBounds);
    }

    private static boolean isOutOfBounds(int number) {
        int MINIMUM = LottoRule.MINIMUM_NUMBER.getValue();
        int MAXIMUM = LottoRule.MAXIMUM_NUMBER.getValue();
        if (number < MINIMUM || number > MAXIMUM) {
            return true;
        }
        return false;
    }

    private static boolean containsDuplicatedNumber(List<Integer> lottoNumbers) {
        int distinctedNumbersCount = (int) lottoNumbers.stream().distinct().count();
        if (distinctedNumbersCount != LottoRule.NUMBERS_COUNT.getValue()) {
            return true;
        }
        return false;
    }
}
