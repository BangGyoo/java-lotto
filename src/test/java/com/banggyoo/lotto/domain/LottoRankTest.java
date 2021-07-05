package com.banggyoo.lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoRankTest {


    @Test
    void 주어진_match_count를_하여_rank_반환_1등() {
        int matchCount = 6;
        assertThat(LottoRank.calcRank(matchCount)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void 주어진_match_count를_하여_rank_반환_2등() {
        int matchCount = 5;
        assertThat(LottoRank.calcRank(matchCount)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    void 주어진_match_count를_하여_rank_반환_3등() {
        int matchCount = 4;
        assertThat(LottoRank.calcRank(matchCount)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void 주어진_match_count를_하여_rank_반환_4등() {
        int matchCount = 3;
        assertThat(LottoRank.calcRank(matchCount)).isEqualTo(LottoRank.FOURTH);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void 주어진_match_count를_이용하여_rank_반환_꽝(int matchCount) {
        assertThat(LottoRank.calcRank(matchCount)).isEqualTo(LottoRank.NOTHING);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 7, 10})
    void 음수_또는_6보다_큰_match_count가_입력될_시_에러_발생(int matchCount) {
        assertThatThrownBy(() -> LottoRank.calcRank(matchCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("matchCount는 0보다 크거나 같고 6보다 작거나 같아야 합니다.");
    }



}