package com.banggyoo.lotto.domain;

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

    @Test
    void 문자열로_된_금액을_저장한다() {
        assertThat(new Money("2000")).isEqualTo(new Money(2000));
    }

    @Test
    void 정수형이_아닌_문자열이_들어오면_에러발생() {
        assertThatThrownBy(() -> new Money("2.2")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 살수있는_로또의_값을_계산한다() {
        assertThat(new Money(2800).calcPossibleLottoQuantity()).isEqualTo(2);
    }

    @Test
    void 로또금액의_수익률을_계산한다() {
        assertThat(new Money(10000).calculateYield(10000)).isEqualTo(1f);
    }


}



