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
    private static final String WINNING_LOTTO_BONUS_REGEX = "[^0-9]";
    private static final String WINNING_LOTTO_INVALID_ERROR_MESSAGE = "쉼표(,)와 숫자만 입력 가능 합니다.";
    public static final String WINNING_LOTTO_BONUS_NUMBER_INVALID_ERROR_MESSAGE = "숫자만 입력 가능 합니다.";

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


    public WinningLotto createWinningLotto() {
        List<Integer> lottoNumbers = findWinningLottoNumbers();
        int lottoBonusNumber = findLottoBonusNumber();
        return new WinningLotto(new Lotto(lottoNumbers),new LottoNumber(lottoBonusNumber));
    }

    private int findLottoBonusNumber() {
        String winningLottoBonusNumber = inputView.requestWinningLottoBonusNumberInConsole();
        checkValidInput(winningLottoBonusNumber,WINNING_LOTTO_BONUS_REGEX,WINNING_LOTTO_BONUS_NUMBER_INVALID_ERROR_MESSAGE);
        int lottoBonusNumber = Integer.parseInt(winningLottoBonusNumber);
        return lottoBonusNumber;
    }

    private List<Integer> findWinningLottoNumbers() {
        String winningLottoNumbers = inputView.requestWinningLottoNumbersInConsole();
        checkValidInput(winningLottoNumbers, WINNING_LOTTO_REGEX, WINNING_LOTTO_INVALID_ERROR_MESSAGE);
        List<Integer> lottoNumbers= Stream
                .of(winningLottoNumbers.split(SPLIT_DELIMITER))
                .map(num -> Integer.parseInt(num.trim()))
                .collect(Collectors.toList());
        return lottoNumbers;
    }

    public List<LottoRank> calcRanks(Lottos buyAutoLottos, WinningLotto winningLotto) {
        return buyAutoLottos.countCorrectLottoRank(winningLotto);
    }

    private void checkValidInput(String value, String regex, String errorMessage) {
        Matcher matcher = Pattern.compile(regex).matcher(value);
        if (matcher.find()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
