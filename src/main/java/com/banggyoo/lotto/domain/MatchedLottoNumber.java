package com.banggyoo.lotto.domain;

import java.util.Objects;

public class MatchedLottoNumber {
    private int matchedLottoNumberCount;

    public MatchedLottoNumber(int matchedLottoNumberCount) {
        this.matchedLottoNumberCount = matchedLottoNumberCount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchedLottoNumber that = (MatchedLottoNumber) o;
        return matchedLottoNumberCount == that.matchedLottoNumberCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchedLottoNumberCount);
    }
}
