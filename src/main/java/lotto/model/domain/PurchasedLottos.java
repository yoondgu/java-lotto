package lotto.model.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.dto.LottoDTO;

public class PurchasedLottos {
    private final List<Lotto> purchasedLottos;

    public PurchasedLottos(List<Lotto> purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
    }

    public RankCount computeAllResult(LottoDraw lottoDraw) {
        RankCount rankCount = new RankCount();
        purchasedLottos.stream()
                .map(lottoDraw::computeLottoRank)
                .filter(Objects::nonNull)
                .forEach(rankCount::addCount);
        return rankCount;
    }

    public List<LottoDTO> of() {
        return purchasedLottos.stream()
                .map(lotto -> new LottoDTO(lotto.getNumbers()))
                .collect(Collectors.toList());
    }
}
