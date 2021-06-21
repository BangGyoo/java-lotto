package com.banggyoo.lotto;

import com.banggyoo.lotto.domain.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MoneyTest {

    @Test
    void 구입_금액을_저장한다() {
        assertThat(new Money(1500)).isEqualTo(new Money(1500));
    }

    @Test
    void 돈이_음수이면_에러발생() {
        assertThatThrownBy(() -> new Money(-100)).isInstanceOf(IllegalArgumentException.class).hasMessage("돈은 음수가 될 수 없습니다.");
    }



}



