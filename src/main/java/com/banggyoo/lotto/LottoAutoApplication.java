package com.banggyoo.lotto;

import com.banggyoo.lotto.domain.*;
import com.banggyoo.lotto.service.LottoStore;
import com.banggyoo.lotto.viewer.InputView;
import com.banggyoo.lotto.viewer.ResultView;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class LottoAutoApplication {

    public void run() {
        ResultView resultView = new ResultView();
        InputView inputView = new InputView();
        LottoStore lottoStore = new LottoStore(inputView);
        Money money = (Money) executeExceptionCaseLoop(() -> lottoStore.createBuyMoney());
        resultView.displayPurchaseLottoCount(money);
        Lottos buyAutoLottos = lottoStore.buyAutoLottos(money);
        resultView.displayBuyAutoLottos(buyAutoLottos);
        WinningLotto winningLotto = (WinningLotto) executeExceptionCaseLoop(() -> lottoStore.createWinningLotto());
        List<LottoRank> ranks = lottoStore.calcRanks(buyAutoLottos, winningLotto);
        resultView.displayAnalysis(ranks, money);
    }

    private Object executeExceptionCaseLoop(Callable<Object> function) {
        Object result;
        do {
            result = executeOrNull(function);
        } while(Objects.isNull(result));
        return result;
    }

    private Object executeOrNull(Callable<Object> function) {
        try {
            return function.call();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
