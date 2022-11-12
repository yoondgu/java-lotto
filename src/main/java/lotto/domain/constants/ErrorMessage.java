package lotto.domain.constants;

public enum ErrorMessage {
    LOTTO_INVALID_SIZE("로또 번호 숫자의 개수가 적절하지 않습니다."),
    LOTTO_OUT_OF_BOUNDS("로또 번호 숫자의 범위가 적절하지 않습니다."),
    LOTTO_DUPLICATED("로또 번호는 중복된 숫자를 가질 수 없습니다.")
    ;

    private final String value;

    private ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
