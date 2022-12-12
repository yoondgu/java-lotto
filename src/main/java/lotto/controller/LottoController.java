package lotto.controller;

import lotto.model.LottoService;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        purchaseLotto();
    }

    public void purchaseLotto() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        System.out.println(lottoService.purchaseLottos(purchaseAmount));
    }
}
