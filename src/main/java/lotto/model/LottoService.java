package lotto.model;

import java.util.List;
import lotto.dto.LottoDTO;
import lotto.dto.ResultDTO;
import lotto.model.domain.LottoDraw;
import lotto.model.domain.PurchasedLottos;
import lotto.model.domain.RankCount;

public class LottoService {
    private final LottoMachine lottoMachine = new LottoMachine();
    private PurchasedLottos purchasedLottos;
    private LottoDraw lottoDraw;
    private int purchaseAmount;

    public List<LottoDTO> purchaseLottos(int purchaseAmount) {
        this.purchasedLottos = new PurchasedLottos(lottoMachine.issueLottos(purchaseAmount));
        this.purchaseAmount = purchaseAmount;
        return purchasedLottos.of();
    }

    public void drawLotto(List<Integer> drawNumbers, int bonusNumber) {
        lottoDraw = new LottoDraw(drawNumbers, bonusNumber);
    }

    public ResultDTO computeResult() {
        RankCount rankCount = purchasedLottos.computeAllResult(lottoDraw);
        double profitRate = rankCount.computeProfitRate(purchaseAmount);
        return new ResultDTO(rankCount.of(), profitRate);
    }
}
