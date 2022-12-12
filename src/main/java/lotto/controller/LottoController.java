package lotto.controller;

import java.util.List;
import lotto.dto.LottoDTO;
import lotto.model.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        purchaseLotto();
    }

    public void purchaseLotto() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        List<LottoDTO> purchasedLottos = lottoService.purchaseLottos(purchaseAmount);
        outputView.printPurchasedLottos(purchasedLottos);
    }
}
