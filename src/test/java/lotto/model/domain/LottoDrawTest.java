package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import org.junit.jupiter.api.Test;

class LottoDrawTest {
    @Test
    void 추첨정보_생성_당첨번호_개수_6개_이하_예외발생() {
        assertThatThrownBy(() -> new LottoDraw(newArrayList(1, 2, 3, 4, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 추첨정보_생성_당첨번호_범위_초과_예외발생() {
        assertThatThrownBy(() -> new LottoDraw(newArrayList(1, 2, 3, 4, 5, 46), 6))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoDraw(newArrayList(1, 2, 3, 4, 5, 0), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 추첨정보_생성_당첨번호_중복_예외발생() {
        assertThatThrownBy(() -> new LottoDraw(newArrayList(1, 2, 3, 4, 5, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 추첨정보_생성_보너스번호_범위_초과_예외발생() {
        assertThatThrownBy(() -> new LottoDraw(newArrayList(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoDraw(newArrayList(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 추첨정보_생성_당첨번호_보너스번호_중복_예외발생() {
        assertThatThrownBy(() -> new LottoDraw(newArrayList(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}