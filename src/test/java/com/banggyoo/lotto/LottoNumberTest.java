package com.banggyoo.lotto;

import com.banggyoo.lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    void 로또_숫자를_저장한다() {
        assertThat(new LottoNumber(44)).isEqualTo(new LottoNumber(44));
    }

    @Test
    void 로또숫자_이외의_값이_들어오면_에러() {
        assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(IllegalArgumentException.class).hasMessage("로또는 1부터 45사이의 값입니다.");
    }

    @Test
    void 로또의_숫자가_같은지_확인() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

    @Test
    void 두개의_로또_넘버를_비교() {
        LottoNumber lottoNumber1 = new LottoNumber(7);
        LottoNumber lottoNumber2 = new LottoNumber(7);
//        assertThat(lottoNumber1.isSame(lottoNumber2)).isEqualTo(LottoNumberStatus.CORRECT);
//        assertThat(lottoNumber1.isSame(new LottoNumber(8))).isEqualTo(LottoNumberStatus.WRONG);
    }
}
