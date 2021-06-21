package com.banggyoo.lotto;

import com.banggyoo.lotto.domain.MatchedLottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MatchedLottoTest {

    @Test
    void 로또의_맞춘_개수를_저장한다() {
        assertThat(new MatchedLottoNumber(3)).isEqualTo(new MatchedLottoNumber(3));
    }

}
