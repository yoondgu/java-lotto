package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.TotalLottoResult;
import lotto.domain.constants.LottoRank;
import lotto.view.constants.Format;
import lotto.view.constants.OutputMessage;
import lotto.view.utils.KeyboardReader;
import lotto.view.utils.MessagePrinter;

import java.text.DecimalFormat;
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
        MessagePrinter.printLine(Format.STRING_ISSUE_AMOUNT, amount);
    }

    public int askLottoDrawBonusNumber() {
        MessagePrinter.printLine(OutputMessage.ASK_DRAW_BONUS_NUMBER);
        return KeyboardReader.readInteger();
    }

    public void showPurchasedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            MessagePrinter.printLine(lotto);
        }
    }

    public void showTotalLottoResult(TotalLottoResult result) {
        MessagePrinter.printLine(OutputMessage.INFORM_TOTAL_LOTTO_RESULT);
        DecimalFormat currecyFormatter= new DecimalFormat("###,###");
        for (LottoRank lottoRank : LottoRank.values()) {
            // TODO 낙첨 개수 저장 제외 검토
            if (lottoRank == LottoRank.RANK_LOSE) {
                continue;
            }
            Format formatString = Format.STRING_RANK_RESULT;
            if (lottoRank.isRequiredToCheckBonus()) {
                formatString = Format.STRING_RANK_WITH_BONUS_RESULT;
            }
            int count = result.getCountByRank(lottoRank);
            String prize = currecyFormatter.format(lottoRank.getPrize());
            MessagePrinter.printLine(formatString, lottoRank.getRequiredMatchCount(), prize, count);
        }
    }

    public void showEarningRatio(double earningRatio) {
        MessagePrinter.printLine(Format.STRING_EARNING_RATIO, earningRatio);
    }

}
