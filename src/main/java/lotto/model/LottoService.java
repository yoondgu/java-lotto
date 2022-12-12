package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoDTO;
import lotto.dto.ResultDTO;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoDraw;
import lotto.model.domain.RankCount;

public class LottoService {
    private final LottoMachine lottoMachine = new LottoMachine();
    private List<Lotto> purchasedLottos;
    private LottoDraw lottoDraw;
    private int purchaseAmount;

    public List<LottoDTO> purchaseLottos(int purchaseAmount) {
        this.purchasedLottos = lottoMachine.issueLottos(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        return toDTO(purchasedLottos);
    }

    private List<LottoDTO> toDTO(List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> new LottoDTO(lotto.getNumbers()))
                .collect(Collectors.toList());
    }

    public void drawLotto(List<Integer> drawNumbers, int bonusNumber) {
        lottoDraw = new LottoDraw(drawNumbers, bonusNumber);
    }

    public ResultDTO computeResult() {
        RankCount rankCount = lottoDraw.computeAllResult(purchasedLottos);
        double profitRate = rankCount.computeProfitRate(purchaseAmount);
        return new ResultDTO(rankCount.of(), profitRate);
    }
}
