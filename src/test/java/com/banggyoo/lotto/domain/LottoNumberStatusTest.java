package com.banggyoo.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberStatusTest {

    @Test
    void 로또번호의_상태를_저장할_객체를_생성() {
        assertThat(LottoRank.FOURTH).isEqualTo(LottoRank.FOURTH);
    }

}
