package com.banggyoo.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayResultTest {

    @Test
    void 구매한_돈을_저장한다() {
        assertThat(new PlayResult(new Money(10000)))
                .isEqualTo(new PlayResult(new Money(10000)));
    }

    @Test
    void 최종_이익을_계산한다() {
        assertThat(new PlayResult(new Money(10000)).calculateRevenue(1000))
                .isEqualTo("총 수익률은 0.1입니다.");
    }


}
