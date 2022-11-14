package lotto.view.utils;

import lotto.view.constants.Format;
import lotto.view.constants.OutputMessage;

public class MessagePrinter {
    private MessagePrinter() { }

    public static void printLine(Object content) {
        validateMessage(content);
        System.out.println(content);
    }

    public static void printLine(OutputMessage content) {
        validateMessage(content);
        System.out.println(content.getText());
    }

    public static void printLine(Format formatString, Object value) {
        validateMessage(value);
        validateMessage(formatString);
        System.out.println(String.format(formatString.getText(), value));
    }

    public static void printLine(Format formatString, Object value1, Object value2, Object value3) {
        validateMessage(value1);
        validateMessage(value2);
        validateMessage(value3);
        validateMessage(formatString);
        System.out.println(String.format(formatString.getText(), value1, value2, value3));
    }

    private static void validateMessage(Object message) {
        if (message == null) {
            throw new NullPointerException();
        }
    }
}
