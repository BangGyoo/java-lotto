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

    public static final String OUT_BOUND_MATCH_COUNT_ERROR_MESSAGE = "matchCount는 0보다 크거나 같고 6보다 작거나 같아야 합니다.";
    public static final int LOTTO_MATCH_MINIMUM_COUNT = 0;
    public static final int LOTTO_MATCH_MAXIMUM_COUNT = 6;
    private final int matchCount;
    private static final List<LottoRank> ENUM_LIST;

    static {
        ENUM_LIST = Stream.of(LottoRank.values()).collect(Collectors.toList());
    }

    LottoRank(int matchCount) {
        this.matchCount = matchCount;
    }

    public static LottoRank calcRank(int currentMatchCount) {
        invalidLottoMatchCount(currentMatchCount);

        return ENUM_LIST.stream()
                .filter(lottoRank -> lottoRank.matchCount == currentMatchCount)
                .findFirst().orElse(NOTHING);
    }

    private static void invalidLottoMatchCount(int currentMatchCount) {
        if (currentMatchCount < LOTTO_MATCH_MINIMUM_COUNT || currentMatchCount > LOTTO_MATCH_MAXIMUM_COUNT) {
            throw new IllegalArgumentException(OUT_BOUND_MATCH_COUNT_ERROR_MESSAGE);
        }
    }

}
