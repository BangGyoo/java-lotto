package com.banggyoo.lotto.service;

import com.banggyoo.lotto.domain.Money;
import com.banggyoo.lotto.viewer.InputView;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoStoreTest {


    @Test
    void 로또_구매금액_생성() {

        InputView inputView = new InputView() {
            @Override
            public String requestBuyLottoMoney() {
                return "10000";
            }
        };

        LottoStore lottoStore = new LottoStore(inputView);

        Money buyMoney = lottoStore.createBuyMoney();
        assertThat(buyMoney).isEqualTo(new Money(10000));
    }

    @Test
    void 로또_구매_금액이_숫자가_아닌값이_입력시_에러발생() {
        InputView inputView = new InputView() {
            @Override
            public String requestBuyLottoMoney() {
                return "가나";
            }
        };

        LottoStore lottoStore = new LottoStore(inputView);
        assertThatThrownBy(() -> lottoStore.createBuyMoney()).isInstanceOf(IllegalArgumentException.class).hasMessage("숫자만 입력 가능 합니다.");


    }
}