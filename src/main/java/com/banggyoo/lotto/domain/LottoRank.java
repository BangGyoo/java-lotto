package com.banggyoo.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    NOTHING(0),
    FOURTH(3),
    THIRD(4),
    SECOND(5),
    FIRST(6);

    private final int matchCount;
    private static final List<LottoRank> ENUM_LIST;

    static {
        ENUM_LIST = Stream.of(LottoRank.values()).collect(Collectors.toList());
    }

    LottoRank(int matchCount) {
        this.matchCount = matchCount;
    }

    public static LottoRank calcRank(int currentMatchCount) {
        return ENUM_LIST.stream()
                .filter(lottoRank -> lottoRank.matchCount == currentMatchCount)
                .findFirst().orElse(NOTHING);
    }

}
