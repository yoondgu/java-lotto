package lotto.view.utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constants.Format;

import java.util.List;

public class KeyboardReader {
    private static final String REGEX_INTEGER = "^[^0]\\d*";
    private KeyboardReader() { }

//    public static List<Integer> readIntegersWithFormat(Format delimiter) {
//
//    }

    public static int readInteger() {
        String readValue = readLine();
        validateStringToInteger(readValue);
        return Integer.parseInt(readValue);
    }

    public static String readLine() {
        return Console.readLine();
    }

    private static void validateStringToInteger(String value) {
        if (!value.matches(REGEX_INTEGER)) {
            throw new NumberFormatException();
        }
    }
}
