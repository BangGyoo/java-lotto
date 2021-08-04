package com.banggyoo.lotto.domain;

import java.util.Objects;
import java.text.MessageFormat;

public class PlayResult {

    public static final String CALCULATED_REVENUE_RESULT_MESSAGE = "총 수익률은 {0}입니다.";
    private Money money;

    public PlayResult(Money money) {
        this.money = money;
    }

    public String calculateRevenue(long winningPrize) {
        return MessageFormat.format(CALCULATED_REVENUE_RESULT_MESSAGE,money.calculateYield(winningPrize));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayResult that = (PlayResult) o;
        return Objects.equals(money, that.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

}
