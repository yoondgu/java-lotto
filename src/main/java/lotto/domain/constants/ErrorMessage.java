package lotto.domain.constants;

public enum ErrorMessage {
    LOTTO_INVALID_SIZE("로또 번호 숫자의 개수가 적절하지 않습니다."),
    LOTTO_OUT_OF_BOUNDS("로또 번호 숫자의 범위가 적절하지 않습니다."),
    LOTTO_DUPLICATED("로또 번호는 중복된 숫자를 가질 수 없습니다."),

    PAYMENT_NEGATIVE("구입 금액은 음수일 수 없습니다."),
    PAYMENT_ZERO_COUNT("로또는 최소 1개 구매해야 합니다."),
    PAYMENT_HAS_REMAINDER("거스름돈이 필요 없는 금액만 허용됩니다.")
    ;

    private final String value;

    private ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
