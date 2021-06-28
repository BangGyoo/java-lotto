package com.banggyoo.lotto.domain;

import java.util.Arrays;
import java.util.stream.Stream;

public enum LottoRank {
    NOTHING(0),
    FOURTH(3),
    THIRD(4),
    SECOND(5),
    FIRST(6);

    private final int matchCount;

    LottoRank(int matchCount) {
        this.matchCount = matchCount;
    }


    public static boolean isCorrect(LottoRank lottoNumberStatus) {
        if (lottoNumberStatus == FOURTH) {
            return true;
        }
        return false;
    }

    public static LottoRank calcRank(int currentMatchCount) {
        return Stream.of(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchCount == currentMatchCount)
                .findFirst().orElseGet(() -> NOTHING);
    }

}
