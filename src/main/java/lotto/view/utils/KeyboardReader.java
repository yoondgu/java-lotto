package lotto.view.utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constants.ErrorMessage;
import lotto.view.constants.Format;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KeyboardReader {
    private static final String REGEX_INTEGER = "^[^0]\\d*";
    private KeyboardReader() { }

    public static List<Integer> readIntegersWithFormat(Format delimiter) {
        String readValue = readLine();
        String delimterValue = delimiter.getText();
        validateFormattedIntegers(readValue, delimterValue);
        return Arrays.stream(readValue.split(delimterValue))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int readInteger() {
        String readValue = readLine();
        validateStringToInteger(readValue);
        return Integer.parseInt(readValue);
    }

    public static String readLine() {
        return Console.readLine();
    }

    private static void validateFormattedIntegers(String value, String delimiter) {
        String delimiterRemoved = value.replaceAll(delimiter, "");
        if (value.length() == delimiterRemoved.length()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ILLEGAL_FORMAT.getValue());
        }
        if (!delimiterRemoved.matches(REGEX_INTEGER)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_INTEGER.getValue());
        }
        if (value.contains(",0")) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_START_WITH_ZERO.getValue());
        }
    }

    private static void validateStringToInteger(String value) {
        if (!value.matches(REGEX_INTEGER)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_INTEGER.getValue());
        }
    }
}
