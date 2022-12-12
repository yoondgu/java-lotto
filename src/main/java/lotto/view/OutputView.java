package lotto.view;

import java.util.List;
import lotto.dto.LottoDTO;
import lotto.dto.RankDTO;
import lotto.dto.ResultDTO;
import lotto.view.constants.OutputMessage;
import lotto.view.constants.OutputMessageFormat;

public class OutputView {
    public void printPurchasedLottos(List<LottoDTO> lottos) {
        System.out.printf(OutputMessageFormat.INFORM_PURCHASE_LOTTOS_SIZE, lottos.size());
        lottos.stream()
                .map(LottoDTO::getNumbers)
                .forEach(System.out::println);
        System.out.println();
    }

    public void printResult(ResultDTO result) {
        System.out.println(OutputMessage.DRAW_RESULT);
        System.out.println(OutputMessage.LINE_SEPARATOR);
        List<RankDTO> ranks = result.getRankCount();
        ranks.forEach(rank -> System.out.printf(OutputMessageFormat.RANK_COUNT, rank.getRuleCount(),
                OutputMessageFormat.LOCALE_MONEY.format(rank.getPrize()), rank.getWinningCount()));
        System.out.printf(OutputMessageFormat.PROFIT_RATE, result.getProfitRate());
    }
}
