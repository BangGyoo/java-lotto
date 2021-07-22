package com.banggyoo.lotto.domain;

import java.util.Objects;

public class WinningLotto {
    Lotto lotto;
    LottoNumber lottoNumber;

    public WinningLotto(Lotto lotto, LottoNumber lottoNumber) {
        this.lotto = lotto;
        this.lottoNumber = lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) && Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, lottoNumber);
    }
}
