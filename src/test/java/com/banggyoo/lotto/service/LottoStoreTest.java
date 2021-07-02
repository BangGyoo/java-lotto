package com.banggyoo.lotto.service;

import com.banggyoo.lotto.domain.Lotto;
import com.banggyoo.lotto.domain.LottoRank;
import com.banggyoo.lotto.domain.Lottos;
import com.banggyoo.lotto.domain.Money;
import com.banggyoo.lotto.viewer.InputView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    void 구매가능_개수만큼_랜덤_로또를_생성한다() {
        assertThat(new LottoStore(new InputView()).buyAutoLottos(new Money(4500))).isInstanceOf(Lottos.class);
    }

    @Test
    void 당첨_번호_입력_기능() {
        InputView inputView = new InputView() {
            @Override
            public String requestWinningLottoNumbers() {
                return "1, 2, 3, 4, 5, 6";
            }
        };

        LottoStore lottoStore = new LottoStore(inputView);
        Lotto winningLotto = lottoStore.createWinningLotto();

        assertThat(winningLotto).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 구분자가_쉼표가_아닌값이_입력시_에러발생() {
        InputView inputView = new InputView() {
            @Override
            public String requestWinningLottoNumbers() {
                return "1| 2# 3, 4, 5, 6";
            }
        };

        LottoStore lottoStore = new LottoStore(inputView);
        assertThatThrownBy(() -> lottoStore.createWinningLotto()).isInstanceOf(IllegalArgumentException.class).hasMessage("쉼표(,)와 숫자만 입력 가능 합니다.");
    }

    @Test
    void 로또가_맞은_등수들을_반환한다() {
        Lottos buyAutoLottos = new Lottos(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Lotto(Arrays.asList(1, 2, 5, 6, 10, 12))));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(new LottoStore(new InputView()).calcRanks(buyAutoLottos, winningLotto)).contains(LottoRank.FIRST, LottoRank.THIRD);
    }

}