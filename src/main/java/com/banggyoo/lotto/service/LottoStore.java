package com.banggyoo.lotto.service;

import com.banggyoo.lotto.domain.Lotto;
import com.banggyoo.lotto.domain.LottoRank;
import com.banggyoo.lotto.domain.Lottos;
import com.banggyoo.lotto.domain.Money;
import com.banggyoo.lotto.viewer.InputView;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoStore {

    public static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자만 입력 가능 합니다.";
    public static final String REGEX = "[^0-9]+";
    private final InputView inputView;

    public LottoStore(InputView inputView) {
        this.inputView = inputView;
    }

    public Money createBuyMoney() {
        String moneyStr = inputView.requestBuyLottoMoney();
        checkValidNumber(moneyStr);
        return new Money(moneyStr);
    }

    private void checkValidNumber(String moneyStr) {
        Matcher matcher = Pattern.compile(REGEX).matcher(moneyStr);
        if (matcher.find()) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }


    public Lottos buyAutoLotto(Money money) {

        return null;
    }

    public List<LottoRank> calcRanks(Lottos buyAutoLotto, Lotto winningLotto) {
        return null;
    }
}
