package com.banggyoo.lotto.domain;

import java.util.Objects;

public class Money {
    public static final String MINUS_MONEY_ERROR_MESSAGE = "돈은 음수가 될 수 없습니다.";
    public static final int LOTTO_PAYMENT = 1000;
    private final int money;

    public Money(int money) {
        invalidMinusMoney(money);
        this.money = money;
    }

    public Money(String money) {
        this(Integer.parseInt(money));
    }

    public int calcPossibleLottoQuantity() {
        return money / LOTTO_PAYMENT;
    }

    private void invalidMinusMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(MINUS_MONEY_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
