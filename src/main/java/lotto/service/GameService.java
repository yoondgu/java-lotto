package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoDraw;
import lotto.domain.LottoSeller;
import lotto.domain.PaymentCalculator;
import lotto.domain.TotalLottoResult;
import lotto.domain.constants.LottoRank;

import java.util.List;
import java.util.Map;

public class GameService {
    private static final GameService instance = new GameService();
    private PaymentCalculator calculator;
    private LottoDraw lottoDraw;

    private GameService() { }

    public static GameService getInstance() {
        return instance;
    }

    public void initializePaymentCalculator(int payment) {
        this.calculator = new PaymentCalculator(payment);
    }

    public int calculatePurchaseAmount() {
        return calculator.calculateAmountByLottoPrice();
    }

    public List<Lotto> sellLottosByAmount(int amount) {
        return LottoSeller.issueLottosByAmount(amount);
    }

    public void drawLotto(List<Integer> drawnNumbers, int drawnBonusNumber) {
        this.lottoDraw = new LottoDraw(new Lotto(drawnNumbers), drawnBonusNumber);
    }

    public TotalLottoResult checkTotalLottoResult(List<Lotto> purchasedLottos) {
        Map<LottoRank, Integer> RankedCounts = lottoDraw.sumUpRankedCounts(purchasedLottos);
        return new TotalLottoResult(RankedCounts);
    }

    public double calculateEarningRatio(int totalPrize) {
        return calculator.calculateEarningRatio(totalPrize);
    }
}
