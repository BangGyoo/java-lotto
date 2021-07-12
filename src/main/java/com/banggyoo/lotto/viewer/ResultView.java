package com.banggyoo.lotto.viewer;

import com.banggyoo.lotto.domain.LottoRank;
import com.banggyoo.lotto.domain.Lottos;
import com.banggyoo.lotto.domain.Money;
import com.banggyoo.lotto.domain.PlayResult;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class ResultView {
    private static final String PURCHASE_LOTTO_COUNT_MESSAGE = "개를 구입했습니다.";
    public static final String WINNING_LOTTO_RESULT = "당첨통계\n---------";

    public void displayPurchaseLottoCount(Money money) {
        int lottoCount = money.calcPossibleLottoQuantity();
        System.out.println(lottoCount + PURCHASE_LOTTO_COUNT_MESSAGE);
    }

    public void displayBuyAutoLottos(Lottos buyAutoLottos) {
        System.out.println(buyAutoLottos);
    }

    public void displayAnalysis(List<LottoRank> ranks, Money money) {
        System.out.println(WINNING_LOTTO_RESULT);
        Map<LottoRank, Long> collect = ranks.stream().collect(groupingBy(Function.identity(), counting()));
        List<LottoRank> lottoRanksExceptNothing = LottoRank.getPrintTargetLottoRank();
        long winningPrize = 0;
        for (LottoRank lottoRank : lottoRanksExceptNothing) {
            String lottoRankCountResult = lottoRank.generateWinningResult(collect.getOrDefault(lottoRank,0L));
            System.out.println(lottoRankCountResult);
            winningPrize += lottoRank.calculateWinningPrize(collect.getOrDefault(lottoRank,0L));
        }
        System.out.println(new PlayResult(money).calculateRevenue(winningPrize));
    }
}
