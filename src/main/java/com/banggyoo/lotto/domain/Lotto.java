package com.banggyoo.lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final String LOTTO_SIZE_OUT_OF_BOUND_MESSAGE = "로또는 6자리여야 합니다.";
    public static final int LOTTO_LENGTH = 6;
    private final Set<LottoNumber> lotto;

    public Lotto(List<Integer> lotto) {
        invalidLottoLength(lotto);
        this.lotto = lotto.stream().map(LottoNumber::create).collect(Collectors.toSet());
    }


    private void invalidLottoLength(List<Integer> lotto) {
        if (lotto.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(LOTTO_SIZE_OUT_OF_BOUND_MESSAGE);
        }
    }

    public LottoNumberStatus compareLottoNumber(LottoNumber comparedLottoNumber) {
        LottoNumberStatus currentLottoNumberStatus = LottoNumberStatus.UNKNOWN;
        for (LottoNumber lottoNumber : this.lotto) {
            currentLottoNumberStatus = currentLottoNumberStatus.changeLottoNumberStatus(lottoNumber, comparedLottoNumber);
        }
        return currentLottoNumberStatus;
    }

    public LottoNumberStatus calcMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : lotto.lotto) {
            matchCount += match(lottoNumber);
        }
        return LottoNumberStatus.rank(matchCount);
    }

    private int match(LottoNumber lottoNumber) {
        if (this.lotto.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }


    public int contains(LottoNumber lottoNumber) {
        int resultCount = 0;
        if (lotto.contains(lottoNumber)) {
            resultCount++;
        }
        return resultCount;
    }

    public int compareWinningLottoMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : this.lotto) {
            matchCount += lotto.contains(lottoNumber);
        }
        return matchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

}
