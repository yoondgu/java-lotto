package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.view.constants.InputFormat;
import lotto.view.constants.InputMessage;

public class InputView {
    public int inputPurchaseAmount() {
        System.out.println(InputMessage.INPUT_PURCHASE_AMOUNT);
        String readLine = Console.readLine();
        return InputParser.toInteger(readLine);
    }

    public List<Integer> inputDrawNumbers() {
        System.out.println(InputMessage.INPUT_DRAW_NUMBERS);
        String readLine = Console.readLine();
        return InputParser.toIntegers(readLine.split(InputFormat.DRAW_NUMBERS_DELIMITER));
    }
}
