package lotto.view.constants;

public enum ErrorMessage {
    INPUT_NOT_INTEGER("정수가 아닌 값을 입력하였습니다."),
    INPUT_ILLEGAL_FORMAT("잘못된 형식으로 입력하였습니다."),
    INPUT_START_WITH_ZERO("0으로 시작하는 형식의 숫자를 지원하지 않습니다."),
    ;

    private final String value;

    private ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
