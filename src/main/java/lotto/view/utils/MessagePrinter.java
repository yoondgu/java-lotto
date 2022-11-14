package lotto.view.utils;

import lotto.view.constants.OutputMessage;

public class MessagePrinter {
    private MessagePrinter() { }

    public static void print(OutputMessage content) {
        validateMessage(content);
        System.out.print(content.getText());
    }

    public static void printLine(OutputMessage content) {
        validateMessage(content);
        System.out.println(content.getText());
    }

    public static void printLine(String text) {
        validateMessage(text);
        System.out.println(text);
    }

    private static void validateMessage(Object message) {
        if (message == null) {
            throw new NullPointerException();
        }
    }
}
