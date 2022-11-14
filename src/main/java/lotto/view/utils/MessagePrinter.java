package lotto.view.utils;

import lotto.view.constants.Format;
import lotto.view.constants.OutputMessage;
import lotto.view.validator.IOValidator;

public class MessagePrinter {
    private MessagePrinter() { }

    public static void printLine(Object content) {
        IOValidator.validateMessage(content);
        System.out.println(content);
    }

    public static void printLine(OutputMessage content) {
        IOValidator.validateMessage(content);
        System.out.println(content.getText());
    }

    public static void printLine(Format format, Object value) {
        IOValidator.validateMessage(value);
        IOValidator.validateMessage(format);
        System.out.printf((format.getText()) + "%n", value);
    }

    public static void printLine(Format format, Object value1, Object value2, Object value3) {
        IOValidator.validateMessage(value1);
        IOValidator.validateMessage(value2);
        IOValidator.validateMessage(value3);
        IOValidator.validateMessage(format);
        System.out.printf((format.getText()) + "%n", value1, value2, value3);
    }
}
