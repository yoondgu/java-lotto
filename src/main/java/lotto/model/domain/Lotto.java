package lotto.model.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.model.constants.ErrorMessage;
import lotto.model.constants.LottoRule;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoRule.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INVALID_NUMBERS_SIZE);
        }
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATED_NUMBER);
        }
        numbers.forEach(this::validateNumber);
    }

    private void validateNumber(int number) {
        if (number < LottoRule.LOTTO_MIN_NUMBER || number > LottoRule.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INVALID_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
