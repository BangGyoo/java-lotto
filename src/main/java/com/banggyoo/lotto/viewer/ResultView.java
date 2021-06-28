package com.banggyoo.lotto.viewer;

import com.banggyoo.lotto.domain.LottoRank;
import com.banggyoo.lotto.domain.Lottos;
import com.banggyoo.lotto.domain.Money;

import java.util.List;

public class ResultView {
    private static final String PURCHASE_LOTTO_COUNT_MESSAGE = "개를 구입했습니다.";

    public void displayPurchaseLottoCount(Money money) {
        int lottoCount = money.calcPossibleLottoQuantity();
        System.out.println(lottoCount + PURCHASE_LOTTO_COUNT_MESSAGE);
    }

    public void displayBuyAutoLottos(Lottos buyAutoLottos) {
        System.out.println(buyAutoLottos);
    }

    public void displayAnalysis(List<LottoRank> ranks, Money money) {

    }
}
