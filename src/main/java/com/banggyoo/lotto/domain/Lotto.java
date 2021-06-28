package com.banggyoo.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final String LOTTO_SIZE_OUT_OF_BOUND_MESSAGE = "로또는 6자리여야 합니다.";
    public static final int LOTTO_LENGTH = 6;
    private final Set<LottoNumber> lotto;

    public Lotto(List<Integer> lotto) {
        invalidLottoLength(lotto);
        this.lotto = lotto.stream().map(LottoNumber::create).collect(Collectors.toSet());
    }

    public static Lotto generateAutoLotto() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = LottoNumber.LOTTO_MINIMUM_NUMBER; i <= LottoNumber.LOTTO_MAXIMUM_NUMBER; i++) {
            lottoNumbers.add(i);
        }
        Collections.shuffle(lottoNumbers);
        List<Integer> shuffledLotto = lottoNumbers.subList(0,LOTTO_LENGTH);
        return new Lotto(shuffledLotto);
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');

        this.lotto.stream().collect(Collectors.toList())
                .stream().sorted(LottoNumber::compare).forEach(item -> stringBuilder.append(item + ", "));
        return stringBuilder.toString().replaceAll(", $", "]");
    }
}
