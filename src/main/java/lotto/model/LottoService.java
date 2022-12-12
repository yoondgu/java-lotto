package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoDTO;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoDraw;

public class LottoService {
    private final LottoMachine lottoMachine = new LottoMachine();
    private List<Lotto> purchasedLottos;
    private LottoDraw lottoDraw;

    public List<LottoDTO> purchaseLottos(int purchaseAmount) {
        this.purchasedLottos = lottoMachine.issueLottos(purchaseAmount);
        return toDTO(purchasedLottos);
    }

    private List<LottoDTO> toDTO(List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> new LottoDTO(lotto.getNumbers()))
                .collect(Collectors.toList());
    }
}
