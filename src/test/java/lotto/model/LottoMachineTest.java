package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.domain.Lotto;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private final LottoMachine lottoMachine = new LottoMachine();

    @Test
    void 로또_발행() {
        List<Lotto> lottos = lottoMachine.issueLottos(3000);
        assertThat(lottos.size()).isEqualTo(3);
    }

    @Test
    void 로또_발행_구입금액_1000원_이하이면_예외발생() {
        assertThatThrownBy(() -> lottoMachine.issueLottos(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_발행_구입금액_1000의_배수가_아니면_예외발생() {
        assertThatThrownBy(() -> lottoMachine.issueLottos(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}