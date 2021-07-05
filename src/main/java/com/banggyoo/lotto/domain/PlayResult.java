package com.banggyoo.lotto.domain;

import java.util.Objects;

public class PlayResult {
    private Money money;


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

    public PlayResult(Money money) {
        this.money = money;
    }

    public String calculateRevenue(long winningPrize) {
        return "총 수익률은 " + money.calculateYield(winningPrize) + "입니다.";
    }

}
