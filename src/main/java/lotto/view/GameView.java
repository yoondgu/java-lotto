package lotto.view;

import lotto.domain.Lotto;
import lotto.view.constants.Format;
import lotto.view.constants.OutputMessage;
import lotto.view.utils.KeyboardReader;
import lotto.view.utils.MessagePrinter;

import java.util.List;

public class GameView {
    private static final GameView instance = new GameView();
    public static GameView getInstance() {
        return instance;
    }
    private GameView() { }

    public int askPayment() {
        MessagePrinter.printLine(OutputMessage.ASK_PAYMENT);
        return KeyboardReader.readInteger();
    }

    public List<Integer> askLottoDrawNumbers() {
        MessagePrinter.printLine(OutputMessage.ASK_DRAW_LOTTO_NUMBERS);
        return KeyboardReader.readIntegersWithFormat(Format.DELIMITER_LOTTO_NUMBERS);
    }

    public void showLottoIssueAmount(int amount) {
        MessagePrinter.printLine(amount, Format.SUFFIX_ISSUE_AMOUNT);
    }

    public void showPurchasedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            MessagePrinter.printLine(lotto);
        }
    }


}
