package com.banggyoo.lotto.domain;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    NOTHING(0, 0, false),
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    public static final String OUT_BOUND_MATCH_COUNT_ERROR_MESSAGE = "matchCount는 0보다 크거나 같고 6보다 작거나 같아야 합니다.";
    public static final int LOTTO_MATCH_MINIMUM_COUNT = 0;
    public static final int LOTTO_MATCH_MAXIMUM_COUNT = 6;
    private static final List<LottoRank> ENUM_LIST;
    public static final String MACHED_WINNING_LOTTO_NUMBER_COUNT_MESSAGE = "{0}개 일치{1}({2,number,#})-{3}개";
    public static final String MATCHED_BONUS_NUMBER_MESSAGE = ", 보너스 볼 일치";

    private final int matchCount;
    private final int prizeMoney;
    private final boolean isCorrectedBonusNumber;

    static {
        ENUM_LIST = Stream.of(LottoRank.values()).collect(Collectors.toList());
    }

    LottoRank(int matchCount, int prizeMoney, boolean isCorrectedLotto) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.isCorrectedBonusNumber = isCorrectedLotto;
    }

    public static LottoRank calcRank(int currentMatchCount) {
        invalidLottoMatchCount(currentMatchCount);

        return ENUM_LIST.stream()
                .filter(lottoRank -> lottoRank.matchCount == currentMatchCount)
                .findFirst().orElse(NOTHING);
    }

    public static LottoRank calcRank(int currentMatchCount, boolean isCorrectedBonusNumber) {
        LottoRank lottoRank = calcRank(currentMatchCount);
        if (isCorrectedBonusNumber && lottoRank.equals(THIRD)) {
            return SECOND;
        }
        return lottoRank;
    }

    public static List<LottoRank> getPrintTargetLottoRank() {
        return ENUM_LIST.stream().filter(lottoRank -> lottoRank != NOTHING).collect(Collectors.toList());
    }

    public String generateWinningResult(long matchLottoCount) {
        return MessageFormat.format(MACHED_WINNING_LOTTO_NUMBER_COUNT_MESSAGE,
                matchCount,
                (this.equals(SECOND) ? MATCHED_BONUS_NUMBER_MESSAGE : ""),
                prizeMoney,
                matchLottoCount);
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
