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
        drawLotto();
    }

    public void purchaseLotto() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        List<LottoDTO> purchasedLottos = lottoService.purchaseLottos(purchaseAmount);
        outputView.printPurchasedLottos(purchasedLottos);
    }

    public void drawLotto() {
        List<Integer> drawNumbers = inputView.inputDrawNumbers();
        int bonusNumber = inputView.inputBonusNumber();
        lottoService.drawLotto(drawNumbers, bonusNumber);
    }
}
