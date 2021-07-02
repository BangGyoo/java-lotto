package com.banggyoo.lotto.service;

import com.banggyoo.lotto.domain.*;
import com.banggyoo.lotto.viewer.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {

    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자만 입력 가능 합니다.";
    private static final String BUY_MONEY_REGEX = "[^0-9]+";
    private static final String SPLIT_DELIMITER = ",";
    private static final String WINNING_LOTTO_REGEX = "[^0-9, ]";
    private static final String WINNING_LOTTO_INVALID_ERROR_MESSAGE = "쉼표(,)와 숫자만 입력 가능 합니다.";

    private final InputView inputView;

    public LottoStore(InputView inputView) {
        this.inputView = inputView;
    }

    public Money createBuyMoney() {
        String moneyStr = inputView.requestBuyLottoMoney();
        checkValidInput(moneyStr, BUY_MONEY_REGEX, NUMBER_FORMAT_ERROR_MESSAGE);
        return new Money(moneyStr);
    }


    public Lottos buyAutoLottos(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoQuantity = money.calcPossibleLottoQuantity();
        for (int i = 0; i < lottoQuantity; i++) {
            lottos.add(Lotto.generateAutoLotto());
        }
        return new Lottos(lottos);
    }


    public Lotto createWinningLotto() {
        String strNumbers = inputView.requestWinningLottoNumbers();
        checkValidInput(strNumbers, WINNING_LOTTO_REGEX, WINNING_LOTTO_INVALID_ERROR_MESSAGE);
        List<Integer> lottoNumbers= Stream
                .of(strNumbers.split(SPLIT_DELIMITER))
                .map(num -> Integer.parseInt(num.trim()))
                .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    public List<LottoRank> calcRanks(Lottos buyAutoLottos, Lotto winningLotto) {
        return buyAutoLottos.countCorrectLottoRank(winningLotto);
    }

    private void checkValidInput(String value, String regex, String errorMessage) {
        Matcher matcher = Pattern.compile(regex).matcher(value);
        if (matcher.find()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
