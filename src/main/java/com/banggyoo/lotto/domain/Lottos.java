package com.banggyoo.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<MatchedLottoNumber> compareWinningLottoMatchCount(Lotto winningLotto) {
        List<MatchedLottoNumber> matchedLottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int matchCount = winningLotto.compareWinningLottoMatchCount(lotto);
            matchedLottoNumbers.add(new MatchedLottoNumber(matchCount));
        }
        return matchedLottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : this.lottos) {
            stringBuilder.append(lotto.toString());
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
