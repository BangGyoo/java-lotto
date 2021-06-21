package com.banggyoo.lotto.domain;

import java.util.Objects;

public class LottoNumber {
    public static final String LOTTO_NUMBER_OUT_OF_BOUND_ERROR_MESSAGE = "로또는 1부터 45사이의 값입니다.";
    public static final int LOTTO_MINIMUM_NUMBER = 1;
    public static final int LOTTO_MAXIMUM_NUMBER = 45;
    private final int lottoNumber;


    public LottoNumber(int lottoNumber) {
        invalidLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void invalidLottoNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_MINIMUM_NUMBER || lottoNumber > LOTTO_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_BOUND_ERROR_MESSAGE);
        }
    }

    public static LottoNumber create(int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return Integer.toString(lottoNumber);
    }
}
