package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoSeller;
import lotto.domain.PaymentCalculator;

import java.util.List;

public class GameService {
    private static final GameService instance = new GameService();
    public static GameService getInstance() {
        return instance;
    }
    private GameService() { }

    public PaymentCalculator generatePaymentCalculator(int payment) {
        return new PaymentCalculator(payment);
    }

    public List<Lotto> generateLottoByIssueAmount(int amount) {
        return LottoSeller.issueLottosByAmount(amount);
    }

}
