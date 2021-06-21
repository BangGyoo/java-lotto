package com.banggyoo.lotto.domain;

import java.util.stream.Stream;

public enum LottoNumberStatus {
    WRONG(0),
    CORRECT(3),
    UNKNOWN(4),
    SECOND(5),
    FIRST(6);

    private int matchCount;

    LottoNumberStatus(int matchCount) {
        this.matchCount = matchCount;
    }


    public static boolean isCorrect(LottoNumberStatus lottoNumberStatus) {
        if (lottoNumberStatus == CORRECT) {
            return true;
        }
        return false;
    }

    public static LottoNumberStatus rank(int matchCount) {
        return Stream.of(LottoNumberStatus.values()).filter(status -> status.matchCount == matchCount).findFirst().orElse(WRONG);
    }

    // TODO : 네이밍 바꾸자!
    public LottoNumberStatus changeLottoNumberStatus(LottoNumber lottoNumber, LottoNumber comparedLottoNumber) {
        if (this.equals(CORRECT)) {
            return this;
        }
        if (lottoNumber.equals(comparedLottoNumber)) {
            return LottoNumberStatus.CORRECT;
        }
        return LottoNumberStatus.WRONG;
    }

}
