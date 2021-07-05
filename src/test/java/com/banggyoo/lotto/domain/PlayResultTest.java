package com.banggyoo.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayResultTest {

    @Test
    void 구매한_돈을_저장한다() {
        assertThat(new PlayResult(new Money(10000)))
                .isEqualTo(new PlayResult(new Money(10000)));
    }
}
