package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.PaymentCalculator;
import lotto.service.GameService;
import lotto.view.GameView;

import java.util.List;

public class GameController {
    private static final GameView gameView = GameView.getInstance();
    private static final GameService gameService = GameService.getInstance();

    public static void runGame() {
        int lottoPayment = gameView.askPayment();
        // TODO paymentCalculator 싱글톤 처리
        PaymentCalculator paymentCalculator = gameService.generatePaymentCalculator(lottoPayment);
        int issueAmount = paymentCalculator.calculateIssueAmountByPayment();
        gameView.showLottoIssueAmount(issueAmount);
        List<Lotto> purchasedLottos = gameService.generateLottoByIssueAmount(issueAmount);
        gameView.showPurchasedLottos(purchasedLottos);
        List<Integer> lottoDrawNumbers = gameView.askLottoDrawNumbers();
//        System.out.println(lottoDrawNumbers);
    }
}
