package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constants.InputMessage;

public class InputView {
    public int inputPurchaseAmount() {
        System.out.println(InputMessage.INPUT_PURCHASE_AMOUNT);
        String readLine = Console.readLine();
        return InputParser.toInteger(readLine);
    }
}
