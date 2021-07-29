package com.banggyoo.lotto.domain;

import java.util.Objects;

public class WinningLotto {
    private Lotto lotto;
    private LottoNumber bonusLottoNumber;

    public WinningLotto(Lotto lotto, LottoNumber lottoNumber) {
        if (lotto.isSameLottoNumber(lottoNumber)) {
            throw new IllegalArgumentException("보너스 번호와 로또 번호는 겹칠 수 없습니다.");
        }
        this.lotto = lotto;
        this.bonusLottoNumber = lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) && Objects.equals(bonusLottoNumber, that.bonusLottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonusLottoNumber);
    }

    public LottoRank compareToLotto(Lotto lotto) {

        boolean isCorrectedBonusLottoNumber = lotto.isSameLottoNumber(bonusLottoNumber);
        LottoRank lottoRank = lotto.calcMatchCount(this.lotto);
        if (isCorrectedBonusLottoNumber && LottoRank.THIRD.equals(lottoRank)) {
            return LottoRank.SECOND;
        }
        return lottoRank;
    }
}
