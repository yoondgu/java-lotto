package lotto.domain.validator;

import lotto.domain.constants.ErrorMessage;
import lotto.domain.constants.LottoRule;

import java.util.List;

public class NumbersValidator {
    public static void validateWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateLottoNumbers(winningNumbers);
        if (isOutOfBounds(bonusNumber)) {
            throw  new IllegalArgumentException();
        }
        if (containsThisNumber(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException();
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

    // TODO 당첨 결과 계산 시 재사용 가능 여부 검토할 것.
    private static boolean containsThisNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            return true;
        }
        return false;
    }

    private static boolean hasInvalidSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LottoRule.NUMBERS_COUNT.getValue()) {
            return true;
        }
        return false;
    }

    private static boolean containsOutOfBoundsNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .anyMatch(NumbersValidator::isOutOfBounds);
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
