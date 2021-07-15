package com.banggyoo.lotto.domain;

import com.banggyoo.lotto.domain.Lotto;
import com.banggyoo.lotto.domain.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottosTest {

    Lottos lottos;

    @BeforeEach
    void init() {
        lottos = new Lottos(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Lotto(Arrays.asList(1, 2, 5, 6, 10, 12))));
    }


    @Test
    void 여러개의_로또를_담을_객체_생성() {
        List<Lotto> lottos1 = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Lotto(Arrays.asList(1, 2, 5, 6, 10, 12)));
        Lottos expectedSameLottos = new Lottos(lottos1);

        assertThat(lottos).isEqualTo(expectedSameLottos);
    }

    @Test
    void 로또들을_담을_객체_데이터가_지정된_문자열로_결과가_나오는지_확인() {
        assertThat(lottos.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]\n[1, 2, 5, 6, 10, 12]\n");
    }

    @Test
    void 로또의_등수를_반환() {
        assertThat(lottos.countCorrectLottoRank(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))).toArray())
                .contains(LottoRank.FIRST, LottoRank.THIRD);
    }

}