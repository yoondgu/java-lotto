package lotto.domain.validator;

import lotto.domain.constants.ErrorMessage;
import lotto.domain.constants.LottoRule;

import java.util.List;

public class NumbersValidator {
    public static void validateLottoNumbers(List<Integer> lottoNumbers) {
        if (hasInvalidSize(lottoNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INVALID_SIZE.getValue());
        }
        if (containsOutOfBoundsNumber(lottoNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_OUT_OF_BOUNDS.getValue());
        }
        if (containsDuplicatedNumber(lottoNumbers)) {
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
        int MINIMUM = LottoRule.MINIMUM_NUMBER.getValue();
        int MAXIMUM = LottoRule.MAXIMUM_NUMBER.getValue();
        return lottoNumbers.stream()
                .anyMatch(number -> (number < MINIMUM || number > MAXIMUM));
    }

    private static boolean containsDuplicatedNumber(List<Integer> lottoNumbers) {
        int distinctedNumbersCount = (int) lottoNumbers.stream().distinct().count();
        if (distinctedNumbersCount != LottoRule.NUMBERS_COUNT.getValue()) {
            return true;
        }
        return false;
    }
}
