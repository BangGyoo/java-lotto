package com.banggyoo.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final String LOTTO_SIZE_OUT_OF_BOUND_MESSAGE = "로또는 6자리여야 합니다.";
    public static final int LOTTO_LENGTH = 6;
    private final Set<LottoNumber> lotto;
    private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();

    static {
        for (int i = LottoNumber.LOTTO_MINIMUM_NUMBER; i <= LottoNumber.LOTTO_MAXIMUM_NUMBER; i++) {
            LOTTO_NUMBERS.add(i);
        }
    }

    public Lotto(List<Integer> lotto) {
        invalidLottoLength(lotto);
        this.lotto = lotto.stream().map(LottoNumber::create).collect(Collectors.toSet());
    }

    public static Lotto generateAutoLotto() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> shuffledLotto = LOTTO_NUMBERS.subList(0, LOTTO_LENGTH);
        return new Lotto(shuffledLotto);
    }

    private void invalidLottoLength(List<Integer> lotto) {
        if (lotto.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(LOTTO_SIZE_OUT_OF_BOUND_MESSAGE);
        }
    }

    public boolean isSameLottoNumber(LottoNumber comparedLottoNumber) {
        return this.lotto.stream().anyMatch(lottoNumber -> lottoNumber.equals(comparedLottoNumber));
    }

    public LottoRank calcMatchCount(Lotto lotto) {
        int currentMatchCount = 0;
        for (LottoNumber lottoNumber : lotto.lotto) {
            if (isSameLottoNumber(lottoNumber)) {
                currentMatchCount++;
            }
        }
        return LottoRank.calcRank(currentMatchCount);
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
