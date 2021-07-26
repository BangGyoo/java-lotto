package com.banggyoo.lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
        assertThat(LottoRank.calcRank(matchCount, true)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    void 주어진_match_count를_하여_rank_반환_3등() {
        int matchCount = 5;
        assertThat(LottoRank.calcRank(matchCount)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void 주어진_match_count를_하여_rank_반환_4등() {
        int matchCount = 4;
        assertThat(LottoRank.calcRank(matchCount)).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void 주어진_match_count를_하여_rank_반환_5등() {
        int matchCount = 3;
        assertThat(LottoRank.calcRank(matchCount)).isEqualTo(LottoRank.FIFTH);
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

    @ParameterizedTest
    @CsvSource(value = {
            "NOTHING|0개 일치(0)-2개",
            "FIFTH|3개 일치(5000)-2개",
            "FOURTH|4개 일치(50000)-2개",
            "THIRD|5개 일치(1500000)-2개",
            "SECOND|5개 일치, 보너스 볼 일치(30000000)-2개",
            "FIRST|6개 일치(2000000000)-2개"},
            delimiter = '|')
    void 로또번호가_몇개맞았는지_출력(LottoRank lottoRank, String expected) {
        assertThat(lottoRank.generateWinningResult(2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"NOTHING,0", "FOURTH,100000", "THIRD,3000000", "SECOND,60000000", "FIRST,4000000000"})
    void 상금을_계산한다(LottoRank lottoRank, long expected) {
        assertThat(lottoRank.calculateWinningPrize(2)).isEqualTo(expected);
    }


}