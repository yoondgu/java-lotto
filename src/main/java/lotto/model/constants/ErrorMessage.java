package lotto.model.constants;

public class ErrorMessage {
    public static final String PURCHASE_AMOUNT_INVALID_VALUE = "구매 금액이 잘못되었습니다. 로또 1장 금액: " + LottoRule.LOTTO_PRICE;
    public static final String LOTTO_INVALID_NUMBERS_SIZE = "로또 번호의 개수가 잘못되었습니다.";
    public static final String LOTTO_INVALID_NUMBER = "로또 번호 중 잘못된 범위의 수가 존재합니다.";
    public static final String LOTTO_DUPLICATED_NUMBER = "로또 번호 중 중복된 수가 존재합니다.";
    public static final String LOTTO_INVALID_BONUS_NUMBER = "보너스 번호의 범위가 잘못되었습니다.";
    public static final String LOTTO_DUPLICATED_BONUS_NUMBER = "로또 번호와 보너스 번호 간 중복된 수가 존재합니다.";
}
