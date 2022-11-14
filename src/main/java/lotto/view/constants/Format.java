package lotto.view.constants;

public enum Format {
    SUFFIX_ISSUE_AMOUNT("개를 구매했습니다."),
    DELIMITER_LOTTO_NUMBERS(","),
    PREFIX_ERROR("[ERROR]"),
    ;

    private final String text;

    private Format(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
