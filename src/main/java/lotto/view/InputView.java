package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.view.constants.InputFormat;
import lotto.view.constants.InputMessage;

public class InputView {
    public int inputPurchaseAmount() {
        System.out.println(InputMessage.INPUT_PURCHASE_AMOUNT);
        return InputParser.toInteger(Console.readLine());
    }

    public List<Integer> inputDrawNumbers() {
        System.out.println(InputMessage.INPUT_DRAW_NUMBERS);
        String readLine = Console.readLine();
        return InputParser.toIntegers(readLine.split(InputFormat.DRAW_NUMBERS_DELIMITER));
    }

    public int inputBonusNumber() {
        System.out.println(InputMessage.INPUT_BONUS_NUMBER);
        return InputParser.toInteger(Console.readLine());
    }
}
