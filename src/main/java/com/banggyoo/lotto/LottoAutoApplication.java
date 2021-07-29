package com.banggyoo.lotto;

import com.banggyoo.lotto.domain.*;
import com.banggyoo.lotto.service.LottoStore;
import com.banggyoo.lotto.viewer.InputView;
import com.banggyoo.lotto.viewer.ResultView;

import java.util.List;

public class LottoAutoApplication {

    public void run() {
        ResultView resultView = new ResultView();
        InputView inputView = new InputView();
        LottoStore lottoStore = new LottoStore(inputView);
        Money money = lottoStore.createBuyMoney();
        resultView.displayPurchaseLottoCount(money);
        Lottos buyAutoLottos = lottoStore.buyAutoLottos(money);
        resultView.displayBuyAutoLottos(buyAutoLottos);
        WinningLotto winningLotto = lottoStore.createWinningLotto();
        List<LottoRank> ranks = lottoStore.calcRanks(buyAutoLottos, winningLotto);
        resultView.displayAnalysis(ranks, money);
    }
}
