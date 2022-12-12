package lotto.view;

import java.util.List;
import lotto.dto.LottoDTO;
import lotto.view.constants.OutputMessageFormat;

public class OutputView {
    public void printPurchasedLottos(List<LottoDTO> lottos) {
        System.out.printf(OutputMessageFormat.INFORM_PURCHASE_LOTTOS_SIZE, lottos.size());
        lottos.stream()
                .map(LottoDTO::getNumbers)
                .forEach(System.out::println);
        System.out.println();
    }
}
