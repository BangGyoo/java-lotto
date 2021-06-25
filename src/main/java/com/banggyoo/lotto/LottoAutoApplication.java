package com.banggyoo.lotto;

import com.banggyoo.lotto.domain.Lotto;
import com.banggyoo.lotto.domain.LottoRank;
import com.banggyoo.lotto.domain.Lottos;
import com.banggyoo.lotto.domain.Money;
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
        Lottos buyAutoLotto = lottoStore.buyAutoLotto(money);
        resultView.displayBuyAutoLotto(buyAutoLotto);
        List<Integer> winningLottoNumbers = inputView.requestInputWinningLottoNumbers();
        Lotto winningLotto = new Lotto(winningLottoNumbers);
        List<LottoRank> ranks = lottoStore.calcRanks(buyAutoLotto, winningLotto);
        resultView.displayAnalysis(ranks, money);
    }
}
