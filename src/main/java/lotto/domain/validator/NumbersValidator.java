package lotto.domain.validator;

import java.util.List;

public class NumbersValidator {
    public static void validateLottoNumbers(List<Integer> lottoNumbers) {
        // TODO 각 예외사항에 적절한 에러메시지 Message 클래스에서 가져와 사용하기
        if (hasInvalidSize(lottoNumbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 숫자의 개수가 적절하지 않습니다.");
        }
        if (containsOutOfBoundsNumber(lottoNumbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 숫자의 범위가 적절하지 않습니다.");
        }
        if (containsDuplicatedNumber(lottoNumbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자를 가질 수 없습니다.");
        }
    }

    private static boolean hasInvalidSize(List<Integer> lottoNumbers) {
        // TODO 번호 개수 6 NumberRule 클래스에 저장하기
        if (lottoNumbers.size() != 6) {
            return true;
        }
        return false;
    }

    private static boolean containsOutOfBoundsNumber(List<Integer> lottoNumbers) {
        // TODO 최솟값 최댓값 NumberRule 클래스에 저장하기
        return lottoNumbers.stream()
                .anyMatch(number -> number < 1 || number > 45);
    }

    private static boolean containsDuplicatedNumber(List<Integer> lottoNumbers) {
        int distinctedNumbersCount = (int) lottoNumbers.stream().distinct().count();
        // TODO 번호 개수 6 대신 NumberRule 클래스의 값 가져와 사용하기
        if (distinctedNumbersCount != 6) {
            return true;
        }
        return false;
    }
}
