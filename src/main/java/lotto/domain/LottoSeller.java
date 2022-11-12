package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.constants.LottoRule;

import java.util.List;

public class LottoSeller {
    private List<Integer> generateLottoNumbersByRandom() {
        int startInclusive = LottoRule.MINIMUM_NUMBER.getValue();
        int endInclusive = LottoRule.MAXIMUM_NUMBER.getValue();
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive,6);
    }
}
