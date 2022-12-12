package lotto.view.constants;

import java.text.DecimalFormat;
import lotto.dto.RankDTO;

public class OutputMessageFormat {
    public static final String INFORM_PURCHASE_LOTTOS_SIZE = "%d개를 구매했습니다." + System.lineSeparator();
    public static final String RANK_COUNT = "%d개 일치 (%s원) - %d개" + System.lineSeparator();
    public static final String RANK_COUNT_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개" + System.lineSeparator();
    public static final String PROFIT_RATE = "총 수익률은 %.1f%%입니다." + System.lineSeparator();
    public static final String INFORM_ERROR = "[ERROR] %s" + System.lineSeparator();
    
    public static final DecimalFormat LOCALE_MONEY = new DecimalFormat("###,###");

    public static String decideRankCountFormat(RankDTO rank) {
        if (rank.isToMatchBonus()) {
            return OutputMessageFormat.RANK_COUNT_WITH_BONUS;
        }
        return OutputMessageFormat.RANK_COUNT;
    }
}
