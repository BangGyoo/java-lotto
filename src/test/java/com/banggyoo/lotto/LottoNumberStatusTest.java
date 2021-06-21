package com.banggyoo.lotto;

import com.banggyoo.lotto.domain.LottoNumberStatus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberStatusTest {

    @Test
    void 로또번호의_상태를_저장할_객체를_생성() {
        assertThat(LottoNumberStatus.CORRECT).isEqualTo(LottoNumberStatus.CORRECT);
    }

}
