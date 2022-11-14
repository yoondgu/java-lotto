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
        System.out.print(content.getText());
    }

    public static void printLine(int value, Format suffix) {
        validateMessage(value);
        validateMessage(suffix);
        System.out.println(value + suffix.getText());
    }

    private static void validateMessage(Object message) {
        if (message == null) {
            throw new NullPointerException();
        }
    }
}
