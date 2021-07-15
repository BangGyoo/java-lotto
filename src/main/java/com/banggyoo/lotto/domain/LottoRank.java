package com.banggyoo.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    NOTHING(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    public static final String OUT_BOUND_MATCH_COUNT_ERROR_MESSAGE = "matchCount는 0보다 크거나 같고 6보다 작거나 같아야 합니다.";
    public static final int LOTTO_MATCH_MINIMUM_COUNT = 0;
    public static final int LOTTO_MATCH_MAXIMUM_COUNT = 6;
    private static final List<LottoRank> ENUM_LIST;

    private final int matchCount;
    private final int prizeMoney;

    static {
        ENUM_LIST = Stream.of(LottoRank.values()).collect(Collectors.toList());
    }

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank calcRank(int currentMatchCount) {
        invalidLottoMatchCount(currentMatchCount);

        return ENUM_LIST.stream()
                .filter(lottoRank -> lottoRank.matchCount == currentMatchCount)
                .findFirst().orElse(NOTHING);
    }

    public static List<LottoRank> getPrintTargetLottoRank() {
        return ENUM_LIST.stream().filter(lottoRank -> lottoRank != NOTHING).collect(Collectors.toList());
    }

    public String generateWinningResult(long matchLottoCount) {
        return matchCount + "개 일치(" + prizeMoney + ")-" + matchLottoCount + "개";
    }

    public long calculateWinningPrize(long matchLottoCount) {
        return prizeMoney * matchLottoCount;
    }


    private static void invalidLottoMatchCount(int currentMatchCount) {
        if (currentMatchCount < LOTTO_MATCH_MINIMUM_COUNT || currentMatchCount > LOTTO_MATCH_MAXIMUM_COUNT) {
            throw new IllegalArgumentException(OUT_BOUND_MATCH_COUNT_ERROR_MESSAGE);
        }
    }

}
