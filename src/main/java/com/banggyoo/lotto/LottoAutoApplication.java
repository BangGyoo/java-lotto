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

    InputView inputView;
    ResultView resultView;
    LottoStore lottoStore;

    public LottoAutoApplication() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.lottoStore = new LottoStore();
    }


    public void run() {
        String moneyString = inputView.requestBuyLottoMoney();
        Money money = new Money(moneyString);
        resultView.displayPurchaseLottoCount(money);
        Lottos buyAutoLotto = lottoStore.buyAutoLotto(money);
        resultView.displayBuyAutoLotto(buyAutoLotto);
        List<Integer> winningLottoNumbers = inputView.requestInputWinningLottoNumbers();
        Lotto winningLotto = new Lotto(winningLottoNumbers);
        List<LottoRank> ranks = lottoStore.calcRanks(buyAutoLotto, winningLotto);
        resultView.displayAnalysis(ranks, money);
    }
}
