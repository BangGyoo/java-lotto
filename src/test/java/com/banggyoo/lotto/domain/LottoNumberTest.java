package com.banggyoo.lotto.domain;

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
    void 포장된_객체가_문자열로_변경되는지_확인() {
        assertThat(new LottoNumber(20).toString()).isEqualTo("20");
    }

    @Test
    void 현재_객체가_더_크다면_양수_반환() {
        assertThat(new LottoNumber(30).compare(new LottoNumber(25))).isGreaterThan(0);
    }
}
