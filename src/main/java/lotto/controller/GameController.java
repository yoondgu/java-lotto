package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.TotalLottoResult;
import lotto.service.GameService;
import lotto.view.GameView;

import java.util.List;

public class GameController {
    private static final GameView gameView = GameView.getInstance();
    private static final GameService gameService = GameService.getInstance();

    public static void runGame() {
        int lottoPayment = gameView.askPayment();
        gameService.initializePaymentCalculator(lottoPayment);
        int issueAmount = gameService.calculateIssueAmount();
        gameView.showLottoIssueAmount(issueAmount);

        List<Lotto> purchasedLottos = gameService.sellLottosByAmount(issueAmount);
        gameView.showPurchasedLottos(purchasedLottos);

        List<Integer> drawnNumbers = gameView.askLottoDrawNumbers();
        int drawnBonusNumber = gameView.askLottoDrawBonusNumber();
        gameService.drawLotto(drawnNumbers, drawnBonusNumber);

        TotalLottoResult result = gameService.checkTotalLottoResult(purchasedLottos);
        gameView.showTotalLottoResult(result);
        double earningRatio = gameService.calculateEarningRatio(result.addUpTotalPrizeAmount());
        gameView.showEarningRatio(earningRatio);
    }

    public static void informExitByError(Exception exception) {
        gameView.ShowExitByErrorMessage(exception);
    }
}
