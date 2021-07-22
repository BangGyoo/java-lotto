package com.banggyoo.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    void 당첨로또를_저장할_일급_객체를_생성() {
        assertThat(new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7)))
                .isEqualTo(new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7)));
    }

    @Test
    void 보너스번호와_로또번호들이_겹치면_에러() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(6)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("보너스 번호와 로또 번호는 겹칠 수 없습니다.");
    }

}
