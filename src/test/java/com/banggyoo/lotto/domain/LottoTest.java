package com.banggyoo.lotto.domain;

import com.banggyoo.lotto.domain.Lotto;
import com.banggyoo.lotto.domain.LottoNumber;
import com.banggyoo.lotto.domain.LottoNumberStatus;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {

    @Test
    void 로또를_저장한다() {
        assertThat(new Lotto(Arrays.asList(1,2,3,4,5,6))).isEqualTo(new Lotto(Arrays.asList(1,2,3,4,5,6)));
    }

    @Test
    void 로또는_6개여야한다() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1,2,3,4,5))).isInstanceOf(IllegalArgumentException.class).hasMessage("로또는 6자리여야 합니다.");
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1,2,3,4,5,6,7))).isInstanceOf(IllegalArgumentException.class).hasMessage("로또는 6자리여야 합니다.");
    }

    @Test
    void 하나의_로또_번호와_로또를_비교() {
        assertThat(new Lotto(Arrays.asList(1,2,3,4,5,6)).compareLottoNumber(new LottoNumber(1))).isEqualTo(LottoNumberStatus.CORRECT);
    }

    @Test
    void 로또와_로또를_비교() {
        assertThat(new Lotto(Arrays.asList(1,2,3,4,5,6)).compareWinningLottoMatchCount(new Lotto(Arrays.asList(1,2,3,7,8,9)))).isEqualTo(3);
    }

    @Test
    void 로또에_들어간_데이터가_지정된_문자열로_결과가_나오는지_확인() {
        assertThat(new Lotto(Arrays.asList(1,2,3,4,5,6)).toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
